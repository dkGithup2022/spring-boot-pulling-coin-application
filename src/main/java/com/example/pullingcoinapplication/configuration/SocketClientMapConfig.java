package com.example.pullingcoinapplication.configuration;

import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class SocketClientMapConfig {
    // TODO : 클래스로 만들기.
    @Bean
    public Map<SocketClientIndicator, WebSocketSession> webSocketSessionMap(){
        return new ConcurrentHashMap<>();
    }
}
