package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.Uri;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitTickSocketClientService;
import com.example.pullingcoinapplication.service.upbitSocketClient.d0610.AbstractUpbitSocketClient;
import com.example.pullingcoinapplication.service.upbitSocketClient.d0610.UpbitOrderbookSocketClient;
import com.example.pullingcoinapplication.service.upbitSocketClient.d0610.UpbitTickSocketClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class UpbitSocketClientRestartCronJob {

    private final UpbitTickSocketClientService upbitTickSocketClientService;
    private final UpbitTickSocketClientService upbitOrderbookSocketClientService;

    //TODO : 이거 말고 새로운 자료형 쓰기  taskMap
    @Autowired
    Map<TaskType, Map> taskMap;

    @Autowired
    Map<TaskType, AbstractUpbitSocketClient> task;

    private Map<SocketClientIndicator, WebSocketSession> upbitTickSessionMap;
    private Map<SocketClientIndicator, WebSocketSession> upbitOrderbookSessionMap;

    @PostConstruct
    public void setUp() {
        upbitTickSessionMap = taskMap.get(TaskType.UPBIT_TICK);
        upbitOrderbookSessionMap = taskMap.get(TaskType.UPBIT_ORDERBOOK);
    }


    // @Scheduled(cron = "${property.upbitCron.tick.restartSessions.cronCommand}")
    public void resetAllUpbitTickClient() throws IOException, Exception {
        log.info("clear all socket client sessions");
        for (SocketClientIndicator key : upbitTickSessionMap.keySet()) {
            upbitTickSessionMap.get(key).close();
        }
        upbitTickSessionMap.clear();

        log.info("restart all client sessions ");
        upbitTickSocketClientService.runSocketClientListenerSafe(
                new URI(Uri.UPBIT_SOCKET_URI.getAddress()),
                UpbitCoinCode.values()
        );
        upbitTickSocketClientService.pauseAfterSockRequest();
        upbitTickSocketClientService.stuffGapBetweenRestart(UpbitCoinCode.values());
    }

    @Scheduled(cron = "${property.upbitCron.tick.restartSessions.cronCommand}")
    public void resetAllUpbitTickClient2() throws IOException, Exception {
        listAllSessionsInTask();
        UpbitTickSocketClient socketClient = (UpbitTickSocketClient) task.get(TaskType.UPBIT_TICK);
        Map<SocketClientIndicator, WebSocketSession> sessionMap = socketClient.getSessionMap();
        log.info("clear all socket client sessions");

        for (SocketClientIndicator key : sessionMap.keySet()) {
            sessionMap.get(key).close();
        }
        sessionMap.clear();
        log.info("restart all client sessions ");

        socketClient.runSocketClientListenerSafe();
        Thread.sleep(socketClient.getRequiredWaitTime());
        socketClient.stuffGapBetweenRestart();
        listAllSessionsInTask();
        log.info(" resetAllUpbitTickClient | all sessions restarted ");
    }

    @Scheduled(cron = "${property.upbitCron.orderbook.restartSessions.cronCommand}")
    public void resetAllUpbitOrderBookClient() throws IOException, Exception {
        listAllSessionsInTask();
        UpbitOrderbookSocketClient socketClient = (UpbitOrderbookSocketClient) task.get(TaskType.UPBIT_ORDERBOOK);
        Map<SocketClientIndicator, WebSocketSession> sessionMap = socketClient.getSessionMap();
        log.info("clear all socket client sessions");

        for (SocketClientIndicator key : sessionMap.keySet()) {
            sessionMap.get(key).close();
        }
        sessionMap.clear();
        log.info("restart all client sessions ");

        socketClient.runSocketClientListenerSafe();
        Thread.sleep(socketClient.getRequiredWaitTime());
        listAllSessionsInTask();
        log.info(" resetAllUpbitTickClient | all sessions restarted ");

    }

    private void listAllSessionsInTask() {
        for (TaskType taskType : task.keySet()) {
            AbstractUpbitSocketClient socketClient = task.get(taskType);
            log.info("taskType: {}  | sessionMap : {}", taskType.getName(), socketClient.getSessionMap().toString());
        }
    }

}
