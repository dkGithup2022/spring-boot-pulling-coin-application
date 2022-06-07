package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.Uri;
import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitSocketClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class UpbitSocketClientRestartCronJob {

    private final UpbitSocketClientService upbitSocketClientService;

    @Autowired
    Map<SocketClientIndicator, WebSocketSession> webSocketSessionMap;

    @Scheduled(cron = "${property.upbitCron.restartSessions.cronCommand}")

    public void resetAllClient() throws IOException, Exception {

        log.info("clear all socket client sessions");
        for (SocketClientIndicator key : webSocketSessionMap.keySet()) {
            webSocketSessionMap.get(key).close();
        }
        webSocketSessionMap.clear();

        log.info("restart all client sessions ");
        upbitSocketClientService.runSocketClientListenerSafe(
                new URI(Uri.UPBIT_SOCKET_URI.getAddress()),
                UpbitCoinCode.values()
        );
        upbitSocketClientService.pauseAfterSockRequest();
        upbitSocketClientService.stuffGapBetweenRestart(UpbitCoinCode.values());
    }

}
