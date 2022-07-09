package com.example.pullingcoinapplication.configuration;

import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.socket.socketClient.AbstractSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Configuration
public class TaskSessionMap {
    @Bean
    public Map<TaskType, AbstractSocketClient> taskSocketMap() {
        ConcurrentHashMap map = new ConcurrentHashMap<TaskType, AbstractSocketClient>();
        return map;
    }
}




