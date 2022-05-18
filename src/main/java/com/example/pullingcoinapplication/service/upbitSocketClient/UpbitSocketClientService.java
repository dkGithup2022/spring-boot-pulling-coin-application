package com.example.pullingcoinapplication.service.upbitSocketClient;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.Uri;
import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTickFactory;
import com.example.pullingcoinapplication.service.UpbitTickService;
import com.example.pullingcoinapplication.service.upbitRest.UpbitRestRequestService;
import com.example.pullingcoinapplication.socket.handler.WebSocketClientHandler;
import com.example.pullingcoinapplication.socket.pubsub.SocketClientOnFailSubscriber;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpbitSocketClientService implements SocketClientOnFailSubscriber {

    private final WebSocketClientHandler webSocketHandler;
    private final Map<SocketClientIndicator, WebSocketSession> webSocketSessionMap;
    private final UpbitRestRequestService upbitRestRequestService;
    private final UpbitTickService upbitTickService;

    private URI targetUri;


    // TODO : 쓸모 없는 결합 제거. pubsub
    @PostConstruct
    public void setPubSub() throws URISyntaxException {
        webSocketHandler.setSubscriber(this);
        this.targetUri = new URI(Uri.UPBIT_SOCKET_URI.getAddress());
    }


    // TODO : 너무 긴 함수
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
            for (SocketClientIndicator indicator : webSocketSessionMap.keySet()) {
                if (indicator.getSessionId() == key) {
                    UpbitCoinCode[] coins = indicator.getCoins();
                    log.error("try to close {} ", indicator.coinsToString());
                    webSocketSessionMap.get(indicator).close();
                    webSocketSessionMap.remove(indicator);
                    log.error("try to rerun {}", indicator.coinsToString());
                    runSocketClientListener(targetUri, coins);
                    stuffGapBetweenRestart(coins);
                    return;
                }
            }
            throw new Exception("no valid coin ");
        } catch (Exception e) {
            log.info("error during restart socket {}  | message", e.getMessage());
        }
    }

    public void runSocketClientListenerSafe(URI uri, UpbitCoinCode[] code) throws InterruptedException{
        try{
            runSocketClientListener(uri,code);
        }catch (HttpClientErrorException clientErrorException) {
            if (clientErrorException.getRawStatusCode() == 429) {
                Thread.sleep(2000);
                runSocketClientListener(uri,code);
            }
        }
    }


    public void runSocketClientListener(URI uri, UpbitCoinCode[] code) {
        ListenableFuture<WebSocketSession> listenableFuture = newClientSession(uri);
        setCallbackAndRegisterSessionMap(listenableFuture, code);
    }

    public void stuffGapBetweenRestart(UpbitCoinCode[] codes) throws JsonProcessingException, InterruptedException {
        for(UpbitCoinCode code : codes) {
            stuffGapBetweenRestart(code);
        }
    }


    //TODO : 리스너 등록과 맵 등록 분리하고 싶다.
    private void setCallbackAndRegisterSessionMap(ListenableFuture<WebSocketSession> listenableFuture, UpbitCoinCode[] codes) {
        listenableFuture.addCallback(
                result -> {
                    SocketClientIndicator indicator = new SocketClientIndicator(codes, result.getId());
                    sendInitialMessage(result, codes);
                    webSocketSessionMap.put(indicator, result);
                    log.info("upbit socket clinet callback registered | coin : {}", indicator.coinsToString());

                }, ex -> {
                    log.error("socket connection fail : {}", ex.getMessage());
                });
    }



    public void pauseAfterSockRequest() throws InterruptedException {
        Thread.sleep((1000 * 60 / 100) * 2);
    }

    private ListenableFuture<WebSocketSession> newClientSession(URI uri) {
        return new StandardWebSocketClient().doHandshake(webSocketHandler, null, uri);
    }

    private void sendInitialMessage(WebSocketSession session, UpbitCoinCode[] coins) {
        try {
            log.info("send initial message : {}", getInitialMessage(coins));
            session.sendMessage(getInitialMessage(coins));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }


    private TextMessage getInitialMessage(UpbitCoinCode[] coins) {
        String payload = "";
        for (UpbitCoinCode coin : coins) {
            payload += "\"" + coin.toString() + "\",";
        }
        log.info("payload: {}", "[{\"ticket\":\"UNIQUE_TICKET\"},{\"type\":\"trade\",\"codes\":[" + payload.substring(0, payload.length() - 1) + "]}]");

        return new TextMessage("[{\"ticket\":\"UNIQUE_TICKET\"},{\"type\":\"trade\",\"codes\":[" + payload.substring(0, payload.length() - 1) + "]}]");
    }



    private void stuffGapBetweenRestart(UpbitCoinCode code) throws JsonProcessingException, InterruptedException {
        Thread.sleep(100);
        UpbitTick[] ticks = upbitRestRequestService.getLastestTicks(code);
        log.info("call rest api / codes : {}", code);
        log.info("ticks: {}", ticks);
        for(UpbitTick tick: ticks){
            tick = UpbitTickFactory.of(tick);
            upbitTickService.saveWhenNotExist(tick);
        }
    }


}
