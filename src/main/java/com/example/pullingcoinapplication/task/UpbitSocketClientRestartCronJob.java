package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.service.upbitSocketClient.AbstractUpbitSocketClient;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitOrderbookSocketClient;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitTickSocketClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class UpbitSocketClientRestartCronJob {

    @Autowired
    Map<TaskType, AbstractUpbitSocketClient> taskMap;

    @Scheduled(cron = "${property.upbitCron.tick.restartSessions.cronCommand}")
    public void resetAllUpbitTickClient() throws IOException, Exception {
        listAllSessionsInTask();
        UpbitTickSocketClient socketClient = (UpbitTickSocketClient) taskMap.get(TaskType.UPBIT_TICK);
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
        UpbitOrderbookSocketClient socketClient = (UpbitOrderbookSocketClient) taskMap.get(TaskType.UPBIT_ORDERBOOK);
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
        for (TaskType taskType : taskMap.keySet()) {
            AbstractUpbitSocketClient socketClient = taskMap.get(taskType);
            log.info("taskType: {}  | sessionMap : {}", taskType.getName(), socketClient.getSessionMap().toString());
        }
    }

}
