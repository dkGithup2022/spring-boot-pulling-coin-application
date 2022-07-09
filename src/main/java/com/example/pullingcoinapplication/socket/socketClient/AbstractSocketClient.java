package com.example.pullingcoinapplication.socket.socketClient;


import com.example.pullingcoinapplication.constants.coinCode.CoinCode;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.service.restCall.upbitRest.UpbitRestRequestService;
import com.example.pullingcoinapplication.socket.handler.WebSocketClientPublisherHandler;
import com.example.pullingcoinapplication.socket.pubsub.SocketClientOnFailSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public abstract class AbstractSocketClient implements SocketClientOnFailSubscriber, SocketClient {

    protected final UpbitRestRequestService upbitRestRequestService;
    protected final URI uri;
    protected final WebSocketClientPublisherHandler socketHandler;
    protected final TaskType taskType;
    protected final VendorType vendorType;
    protected final List<CoinCode> codes;
    protected Map<SocketClientIndicator, WebSocketSession> sessionMap;


    public AbstractSocketClient(
            UpbitRestRequestService upbitRestRequestService,
            URI uri,
            WebSocketClientPublisherHandler socketHandler,
            TaskType taskType,
            VendorType vendorType,
            List<CoinCode> codes) {
        this.upbitRestRequestService = upbitRestRequestService;
        this.uri = uri;
        this.socketHandler = socketHandler;
        this.taskType = taskType;
        this.vendorType = vendorType;
        this.codes = codes;
        this.sessionMap = new ConcurrentHashMap<SocketClientIndicator, WebSocketSession>();
    }

    public AbstractSocketClient(
            URI uri,
            WebSocketClientPublisherHandler socketHandler,
            TaskType taskType,
            VendorType vendorType,
            List<CoinCode> codes) {
        this.upbitRestRequestService = null;
        this.uri = uri;
        this.socketHandler = socketHandler;
        this.taskType = taskType;
        this.vendorType = vendorType;
        this.codes = codes;
        this.sessionMap = new ConcurrentHashMap<SocketClientIndicator, WebSocketSession>();
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public List<CoinCode> getCodes() {
        return this.codes;
    }

    public Map<SocketClientIndicator, WebSocketSession> getSessionMap() {
        return sessionMap;
    }


    @Override
    public void runSocketClientListener() {
        registerSubscriber();
        ListenableFuture<WebSocketSession> listenableFuture = newClientSession();
        setCallbackAndRegisterSessionMap(listenableFuture);
    }

    private void registerSubscriber() {
        this.socketHandler.setSubscriber(this);
    }

    private ListenableFuture<WebSocketSession> newClientSession() {
        return new StandardWebSocketClient().doHandshake(socketHandler, null, uri);
    }

    private void setCallbackAndRegisterSessionMap(ListenableFuture<WebSocketSession> listenableFuture) {
        listenableFuture.addCallback(
                result -> {
                    SocketClientIndicator indicator = new SocketClientIndicator(codes.toArray(new CoinCode[codes.size()]), result.getId());
                    sessionMap.put(indicator, result);
                    sendInitialMessage(result);
                    log.info("upbit socket clinet callback registered | coin : {}", indicator.coinsToString());
                }, ex -> {
                    log.error("socket connection fail : {}", ex.getMessage());
                });
    }


    private void sendInitialMessage(WebSocketSession session) {
        try {
            log.info("send initial message : {}", getUpbitInitialMessage().getPayload());
            session.sendMessage(getUpbitInitialMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    //TODO : string builder 써보기
    private TextMessage getUpbitInitialMessage() {
        String socketType;
        String socketTicket;

        String payload = "";
        for (CoinCode coin : codes) {
            payload += "\"" + coin.toString() + "\",";
        }
        payload = payload.substring(0, payload.length() - 1);

        switch (taskType) {
            case UPBIT_TICK:
                socketType = "trade";
                socketTicket = "give_me_ticks_" + UUID.randomUUID();
                return new TextMessage(
                        "[{\"ticket\":\"" + socketTicket + "\"}," +
                                "{\"type\":\"" + socketType + "\"," +
                                "\"codes\":[" + payload + "]}]"
                );
            case UPBIT_ORDERBOOK:
                socketType = "orderbook";
                socketTicket = "give_me_orderbook_" + UUID.randomUUID();
                return new TextMessage(
                        "[{\"ticket\":\"" + socketTicket + "\"}," +
                                "{\"type\":\"" + socketType + "\"," +
                                "\"codes\":[" + payload + "]}]"
                );
            case BITHUMB_TICK:
                return new TextMessage(
                                "{\"type\":\"transaction\"," +
                                "\"symbols\":[" + payload + "]}"
                );
            case BITHUMB_ORDERBOOK:
                return new TextMessage(
                        "{\"type\":\"orderbookdepth\"," +
                                "\"symbols\":[" + payload + "]}"
                );
            default:
                throw new RuntimeException("invlaid taskType");
        }
    }




    public void runSocketClientListenerSafe() throws InterruptedException {
        try {
            runSocketClientListener();
        } catch (HttpClientErrorException clientErrorException) {
            if (clientErrorException.getRawStatusCode() == 429) {
                Thread.sleep(2000);
                runSocketClientListenerSafe();
            }
        }
    }


}
