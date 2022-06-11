package com.example.pullingcoinapplication.configuration;

import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.service.upbitSocketClient.AbstractUpbitSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Configuration
public class TaskSessionMap {
    @Bean
    public Map<TaskType, AbstractUpbitSocketClient> taskSocketMap() {
        ConcurrentHashMap map = new ConcurrentHashMap<TaskType, AbstractUpbitSocketClient>();
        return map;
    }
}




