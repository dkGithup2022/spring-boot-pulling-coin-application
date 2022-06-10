package com.example.pullingcoinapplication.service.upbitSocketClient;


import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTickFactory;
import com.example.pullingcoinapplication.service.tick.UpbitTickService;
import com.example.pullingcoinapplication.service.upbitRest.UpbitRestRequestService;
import com.example.pullingcoinapplication.service.upbitSocketClient.AbstractUpbitSocketClient;
import com.example.pullingcoinapplication.socket.handler.WebSocketClientPublisherHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

import java.net.URI;
import java.util.List;
import java.util.Map;


@Setter(AccessLevel.PRIVATE)
@Slf4j
public class UpbitTickSocketClient extends AbstractUpbitSocketClient {

    private UpbitTickService tickService;

    public UpbitTickSocketClient(UpbitRestRequestService upbitRestRequestService, URI uri, Map<SocketClientIndicator, WebSocketSession> sessionMap, WebSocketClientPublisherHandler socketHandler, TaskType taskType, VendorType vendorType, List<UpbitCoinCode> codes) {
        super(upbitRestRequestService, uri, sessionMap, socketHandler, taskType, vendorType, codes);
    }

    public UpbitTickSocketClient(UpbitRestRequestService upbitRestRequestService, URI uri, Map<SocketClientIndicator, WebSocketSession> sessionMap, WebSocketClientPublisherHandler socketHandler, TaskType taskType, VendorType vendorType, List<UpbitCoinCode> codes, UpbitTickService tickService) {
        super(upbitRestRequestService, uri, sessionMap, socketHandler, taskType, vendorType, codes);
        this.setTickService(tickService);
    }




    @Override
    public int getRequiredWaitTime() {
        return 1000;
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
                        stuffGapBetweenRestart();
                    return;
                }
            }
            throw new Exception("no valid coin ");
        } catch (Exception e) {
            log.info("error during restart socket {}  | message", e.getMessage());
        }
    }

    private void stuffGapBetweenRestart(UpbitCoinCode code) throws JsonProcessingException, InterruptedException {
        Thread.sleep(100);
        List<UpbitTick> ticks = upbitRestRequestService.getLastestTicks(code);
        log.info("call rest api / codes : {}", codes);
        log.info("ticks: {}", ticks);
        for (UpbitTick tick : ticks) {
            tick = UpbitTickFactory.of(tick);
            tickService.saveWhenNotExist(tick);
        }
    }

    public void stuffGapBetweenRestart() throws JsonProcessingException, InterruptedException {
        for (UpbitCoinCode code : codes) {
            stuffGapBetweenRestart(code);
        }
    }

}
