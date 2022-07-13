package com.example.pullingcoinapplication.socket.socketClient.bithumb;

import com.example.pullingcoinapplication.constants.coinCode.CoinCode;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.entity.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.service.bithumb.tick.BithumbTickService;
import com.example.pullingcoinapplication.socket.socketClient.AbstractSocketClient;
import com.example.pullingcoinapplication.socket.handler.WebSocketClientPublisherHandler;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.util.List;

@Slf4j
@Setter(AccessLevel.PRIVATE)
public class BithumbTickSocketClient extends AbstractSocketClient {

    private  BithumbTickService bithumbTickService;

    public BithumbTickSocketClient(URI uri, WebSocketClientPublisherHandler socketHandler, TaskType taskType, VendorType vendorType, List<CoinCode> codes) {
        super(uri, socketHandler, taskType, vendorType, codes);
    }

    public BithumbTickSocketClient( URI uri, WebSocketClientPublisherHandler socketHandler, TaskType taskType, VendorType vendorType, List<CoinCode> codes, BithumbTickService tickService) {
        super( uri, socketHandler, taskType, vendorType, codes);
        this.setBithumbTickService(tickService);
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
                    CoinCode[] coins = indicator.getCoins();
                    log.error("try to close {} ", indicator.coinsToString());
                    sessionMap.get(indicator).close();
                    sessionMap.remove(indicator);
                    log.error("try to rerun {}", indicator.coinsToString());
                    runSocketClientListener();
                }
            }
            throw new Exception("no valid coin ");
        } catch (Exception e) {
            log.info("error during restart socket {}  | message", e.getMessage());
        }
    }

    // 리스타트 로직 필요 .
}
