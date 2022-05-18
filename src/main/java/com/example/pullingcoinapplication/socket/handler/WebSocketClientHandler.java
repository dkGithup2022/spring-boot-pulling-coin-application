package com.example.pullingcoinapplication.socket.handler;


import com.example.pullingcoinapplication.entity.upbit.CallType;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTickFactory;
import com.example.pullingcoinapplication.service.UpbitTickService;
import com.example.pullingcoinapplication.socket.pubsub.SocketClientOnFailPublisher;
import com.example.pullingcoinapplication.socket.pubsub.SocketClientOnFailSubscriber;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;


@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketClientHandler implements WebSocketHandler, SocketClientOnFailPublisher {

    private final UpbitTickService upbitTickService;
    private final ObjectMapper objectMapper;
    private SocketClientOnFailSubscriber subscriber;


    @Override
    public void setSubscriber(SocketClientOnFailSubscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void notifySubscriber(String key) {
        subscriber.notified(key);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("afterConnectionEstablished, session {},", session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String s = StandardCharsets.UTF_8.decode((ByteBuffer) message.getPayload()).toString();
        UpbitTick tick = UpbitTickFactory.of(objectMapper.readValue(s, UpbitTick.class));
        tick.setCallType(CallType.SOCKET);
        upbitTickService.save(tick);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("on error : {}", exception.getMessage());
        notifySubscriber(session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.error("closed : {} | status : {} ", session.getId(), closeStatus.toString());
        if (isInvalidClosing(closeStatus)) {
            notifySubscriber(session.getId());
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    private boolean isInvalidClosing(CloseStatus closeStatus) {
        return closeStatus.getCode() != 1000 && closeStatus.getCode() != 1007;
    }
}
