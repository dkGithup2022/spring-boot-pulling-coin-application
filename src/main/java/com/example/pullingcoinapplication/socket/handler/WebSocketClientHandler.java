package com.example.pullingcoinapplication.socket.handler;


import com.example.pullingcoinapplication.entity.upbit.CallType;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTickFactory;
import com.example.pullingcoinapplication.service.tick.UpbitTickService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;


@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketClientHandler extends WebSocketClientPublisherHandler {

    private final UpbitTickService upbitTickService;
    private final ObjectMapper objectMapper;


    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String s = StandardCharsets.UTF_8.decode((ByteBuffer) message.getPayload()).toString();
        UpbitTick tick = UpbitTickFactory.of(objectMapper.readValue(s, UpbitTick.class));
        tick.setCallType(CallType.SOCKET);
        upbitTickService.save(tick);
    }

}
