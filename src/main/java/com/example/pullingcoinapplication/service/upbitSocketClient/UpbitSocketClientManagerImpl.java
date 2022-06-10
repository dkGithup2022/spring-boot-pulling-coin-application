package com.example.pullingcoinapplication.service.upbitSocketClient;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.Uri;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTickFactory;
import com.example.pullingcoinapplication.service.tick.UpbitTickService;
import com.example.pullingcoinapplication.service.upbitRest.UpbitRestRequestService;
import com.example.pullingcoinapplication.socket.handler.SocketClientHandlerFactory;
import com.example.pullingcoinapplication.socket.handler.WebSocketClientPublisherHandler;
import com.example.pullingcoinapplication.socket.pubsub.SocketClientOnFailSubscriber;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;


// TODO : 제작 빌더 부분 & 구현부 나누기 .... 나눠진 구현부는 ..... 필요한 의존성만 주입받게...

@Service
@RequiredArgsConstructor
@Slf4j
@Setter(AccessLevel.PRIVATE)
@ToString
public class UpbitSocketClientManagerImpl implements SocketClientOnFailSubscriber, UpbitSocketClientManager {


    private final Map<TaskType, Map> taskMap;
    private final UpbitRestRequestService upbitRestRequestService;
    private final SocketClientHandlerFactory socketClientHandlerFactory;
    private final UpbitTickService upbitTickService;


    private URI uri;
    private Map<SocketClientIndicator, WebSocketSession> sessionMap;
    // TODO : 핸들러는 스태틱 팩토리로 받자.
    private WebSocketClientPublisherHandler socketHandler;
    private TaskType taskType;
    private VendorType vendorType;
    private List<UpbitCoinCode> codes;


    @Override
    public UpbitSocketClientManager setType(TaskType taskType) {
        this.setTaskType(taskType);
        return this;
    }

    @Override
    public UpbitSocketClientManager setVendor(VendorType vendorType) {
        this.setVendorType(vendorType);
        return this;
    }

    @Override
    public UpbitSocketClientManager setCoinCodes(List<UpbitCoinCode> codes) {
        this.setCodes(codes);
        return this;
    }

    @Override
    public void initialize() {
        if (!isInitializable())
            throw new RuntimeException("missing arg : " + this.toString());
        try {
            this.uri = createUri();
            this.initilizeWebSocketHandler();
            sessionMap = taskMap.get(taskType);
            runSocketClientListener();
        } catch (Exception e) {
            log.error("error on initializing handler ");
        }
    }

    @Override
    public void runSocketClientListener() {

    }


    private void sendInitialMessage(WebSocketSession session) {
        try {
            log.info("send initial message : {}", getInitialMessage());
            session.sendMessage(getInitialMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }


    @Override
    public void getRequiredWaitTime() {

    }

    @Override
    public void notified(String key) {
        log.info("{} notified : subscriber notified wait for 1000 ", key);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        log.info("{} notified : wakeup and try to reconnect ", key);

        try {
            // TODO :  스트림으로
            for (SocketClientIndicator indicator : sessionMap.keySet()) {
                if (indicator.getSessionId() == key) {
                    UpbitCoinCode[] coins = indicator.getCoins();
                    log.error("try to close {} ", indicator.coinsToString());
                    sessionMap.get(indicator).close();
                    sessionMap.remove(indicator);
                    log.error("try to rerun {}", indicator.coinsToString());
                    runSocketClientListener();
                    if (taskType == TaskType.UPBIT_ORDERBOOK)
                        stuffGapBetweenRestart(coins);
                        return;
                }
            }
            throw new Exception("no valid coin ");
        } catch (Exception e) {
            log.info("error during restart socket {}  | message", e.getMessage());
        }
    }

    private boolean isInitializable() {
        return (isValidTaskType() && vendorType != null && codes != null);
    }

    private URI createUri() throws URISyntaxException {
        switch (vendorType) {
            case UPBIT:
                return new URI(Uri.UPBIT_SOCKET_URI.getAddress());
            case BITHUMB:
                throw new RuntimeException("this vendor is not ready ");
            default:
                throw new RuntimeException("invalid vendor ");
        }
    }

    private boolean isValidTaskType() {
        return (taskType != null && Arrays.asList(TaskType.values()).contains(taskType));
    }

    private void initilizeWebSocketHandler() {
        socketHandler = socketClientHandlerFactory.getHandler(taskType, vendorType);
        socketHandler.setSubscriber(this);
    }

    private ListenableFuture<WebSocketSession> newClientSession() {
        return new StandardWebSocketClient().doHandshake(socketHandler, null, uri);
    }

    private void setCallbackAndRegisterSessionMap(ListenableFuture<WebSocketSession> listenableFuture) {
        listenableFuture.addCallback(
                result -> {
                    SocketClientIndicator indicator = new SocketClientIndicator(codes.toArray(new UpbitCoinCode[codes.size()]), result.getId());
                    sendInitialMessage(result);
                    sessionMap.put(indicator, result);
                    log.info("upbit socket clinet callback registered | coin : {}", indicator.coinsToString());
                }, ex -> {
                    log.error("socket connection fail : {}", ex.getMessage());
                });
    }

    //TODO : string builder 써보기
    private TextMessage getInitialMessage() {
        String socketType;
        String socketTicket;
        switch (taskType) {
            case UPBIT_TICK:
                socketType = "trade";
                socketTicket = "give_me_ticks_" + UUID.randomUUID();
                break;
            case UPBIT_ORDERBOOK:
                socketType = "orderbook";
                socketTicket = "give_me_orderbook_" + UUID.randomUUID();
                break;
            default:
                throw new RuntimeException("invlaid taskType");
        }
        String payload = "";
        for (UpbitCoinCode coin : codes) {
            payload += "\"" + coin.toString() + "\",";
        }
        payload = payload.substring(0, payload.length() - 1);
        return new TextMessage(
                "[{\"ticket\":\"" + socketTicket + "\"}," +
                        "{\"type\":\"" + socketType + "\"," +
                        "\"codes\":[" + payload + "]}]"
        );
    }

    private void stuffGapBetweenRestart(UpbitCoinCode code) throws JsonProcessingException, InterruptedException {
        Thread.sleep(100);
        List<UpbitTick> ticks = upbitRestRequestService.getLastestTicks(code);
        log.info("call rest api / codes : {}", codes);
        log.info("ticks: {}", ticks);
        for (UpbitTick tick : ticks) {
            tick = UpbitTickFactory.of(tick);
            upbitTickService.saveWhenNotExist(tick);
        }
    }

    public void stuffGapBetweenRestart(UpbitCoinCode[] codes) throws JsonProcessingException, InterruptedException {
        for (UpbitCoinCode code : codes) {
            stuffGapBetweenRestart(code);
        }
    }

}
