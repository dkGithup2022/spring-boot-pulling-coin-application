package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.entity.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.socket.socketClient.AbstractSocketClient;
import com.example.pullingcoinapplication.socket.socketClient.bithumb.BithumbOrderbookSocketClient;
import com.example.pullingcoinapplication.socket.socketClient.bithumb.BithumbTickSocketClient;
import com.example.pullingcoinapplication.socket.socketClient.upbit.UpbitOrderbookSocketClient;
import com.example.pullingcoinapplication.socket.socketClient.upbit.UpbitTickSocketClient;
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
public class ReconnectSocketClient {

    @Autowired
    Map<TaskType, AbstractSocketClient> taskMap;

    @Scheduled(cron = "${property.upbitCron.tick.restartSessions.cronCommand}")
    public void reconnectUpbitTickClient() throws IOException, Exception {
        reconnectSocketClient(TaskType.UPBIT_TICK);
    }

    @Scheduled(cron = "${property.upbitCron.orderbook.restartSessions.cronCommand}")
    public void reconnectUpbitOrderBookClient() throws IOException, Exception {
        reconnectSocketClient(TaskType.UPBIT_ORDERBOOK);
    }

    @Scheduled(cron = "${property.upbitCron.tick.restartSessions.cronCommand}")
    public void reconnectBithumbTickClient() throws IOException , Exception{
        reconnectSocketClient(TaskType.BITHUMB_TICK);
    }


    @Scheduled(cron = "${property.upbitCron.tick.restartSessions.cronCommand}")
    public void reconnectBithumbOrderbookClient() throws IOException , Exception{
        reconnectSocketClient(TaskType.BITHUMB_ORDERBOOK);
    }


    public void reconnectSocketClient(TaskType taskType) throws IOException, Exception {
        AbstractSocketClient socketClient = taskMap.get(taskType);
        /*
        switch(taskType){
            case UPBIT_TICK:
                socketClient = (UpbitTickSocketClient) socketClient;
            case UPBIT_ORDERBOOK:
                socketClient = (UpbitTickSocketClient) socketClient;
            case BITHUMB_TICK:
                socketClient = (BithumbTickSocketClient) socketClient;
            case BITHUMB_ORDERBOOK:
                socketClient = (BithumbOrderbookSocketClient) socketClient;
        }
         */

        Map<SocketClientIndicator, WebSocketSession> sessionMap = socketClient.getSessionMap();

        for (SocketClientIndicator key : sessionMap.keySet()) {
            sessionMap.get(key).close();
        }

        sessionMap.clear();
        log.info("try to close {} ", taskType.getName() );
        socketClient.runSocketClientListenerSafe();
        Thread.sleep(socketClient.getRequiredWaitTime());
        listAllSessionsInTask();
        log.info(" reconnectSocketClient | {} sessions restarted " , taskType.getName());
    }



    private void listAllSessionsInTask() {
        for (TaskType taskType : taskMap.keySet()) {
            AbstractSocketClient socketClient = taskMap.get(taskType);
            log.info("taskType: {}  | sessionMap : {}", taskType.getName(), socketClient.getSessionMap().toString());
        }
    }

}
