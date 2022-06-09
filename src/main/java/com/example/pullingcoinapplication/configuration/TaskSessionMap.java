package com.example.pullingcoinapplication.configuration;

import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Configuration
public class TaskSessionMap {

    @Bean
    public Map<TaskType, Map> taskMap() {
        ConcurrentHashMap map = new ConcurrentHashMap<TaskType, Map>();
        map.put(TaskType.UPBIT_TICK, new ConcurrentHashMap<SocketClientIndicator, WebSocketSession>());
        map.put(TaskType.UPBIT_ORDERBOOK, new ConcurrentHashMap<SocketClientIndicator, WebSocketSession>());
        map.put(TaskType.BITHUMB_TICK, new ConcurrentHashMap<SocketClientIndicator, WebSocketSession>());
        map.put(TaskType.UPBIT_ORDERBOOK, new ConcurrentHashMap<SocketClientIndicator, WebSocketSession>());
        return map;
    }
}
