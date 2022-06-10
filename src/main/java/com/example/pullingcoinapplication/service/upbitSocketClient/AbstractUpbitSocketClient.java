package com.example.pullingcoinapplication.service.upbitSocketClient;


import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.service.upbitRest.UpbitRestRequestService;
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

@Slf4j
public abstract class AbstractUpbitSocketClient implements SocketClientOnFailSubscriber, SocketClient {

    protected final UpbitRestRequestService upbitRestRequestService;
    protected final URI uri;
    protected final Map<SocketClientIndicator, WebSocketSession> sessionMap;
    protected final WebSocketClientPublisherHandler socketHandler;
    protected final TaskType taskType;
    protected final VendorType vendorType;
    protected final List<UpbitCoinCode> codes;


    public AbstractUpbitSocketClient(UpbitRestRequestService upbitRestRequestService, URI uri, Map<SocketClientIndicator, WebSocketSession> sessionMap, WebSocketClientPublisherHandler socketHandler, TaskType taskType, VendorType vendorType, List<UpbitCoinCode> codes) {
        this.upbitRestRequestService = upbitRestRequestService;
        this.uri = uri;
        this.sessionMap = sessionMap;
        this.socketHandler = socketHandler;
        this.taskType = taskType;
        this.vendorType = vendorType;
        this.codes = codes;
    }

    public TaskType getTaskType() {
        return taskType;
    }
    public Map<SocketClientIndicator, WebSocketSession> getSessionMap(){
        return sessionMap;
    }

    @Override
    public void runSocketClientListener() {
        registerSubscriber();
        ListenableFuture<WebSocketSession> listenableFuture = newClientSession();
        setCallbackAndRegisterSessionMap(listenableFuture);
    }

    private void registerSubscriber(){
        this.socketHandler.setSubscriber(this);
    }

    private ListenableFuture<WebSocketSession> newClientSession() {
        return new StandardWebSocketClient().doHandshake(socketHandler, null, uri);
    }

    private void setCallbackAndRegisterSessionMap(ListenableFuture<WebSocketSession> listenableFuture) {
        listenableFuture.addCallback(
                result -> {
                    SocketClientIndicator indicator = new SocketClientIndicator(codes.toArray(new UpbitCoinCode[codes.size()]), result.getId());
                    sessionMap.put(indicator, result);
                    sendInitialMessage(result);
                    log.info("upbit socket clinet callback registered | coin : {}", indicator.coinsToString());
                }, ex -> {
                    log.error("socket connection fail : {}", ex.getMessage());
                });
    }


    private void sendInitialMessage(WebSocketSession session) {
        try {
            log.info("send initial message : {}", getInitialMessage().getPayload());
            session.sendMessage(getInitialMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
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
