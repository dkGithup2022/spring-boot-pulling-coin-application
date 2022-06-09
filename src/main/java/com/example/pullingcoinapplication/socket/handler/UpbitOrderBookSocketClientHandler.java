package com.example.pullingcoinapplication.socket.handler;



import com.example.pullingcoinapplication.entity.upbit.CallType;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTickFactory;
import com.example.pullingcoinapplication.service.orderbook.UpbitOrderBookService;
import com.example.pullingcoinapplication.service.tick.UpbitTickService;
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
import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
@Component
@RequiredArgsConstructor
public class UpbitOrderBookSocketClientHandler implements WebSocketHandler, SocketClientOnFailPublisher {

    private final UpbitOrderBookService upbitOrderBookService;
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


    // MEMO (1)
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String s = StandardCharsets.UTF_8.decode((ByteBuffer) message.getPayload()).toString();
        UpbitOrderbook book = objectMapper.readValue(s, UpbitOrderbook.class);
        upbitOrderBookService.save(book);
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("on error : {}", exception.getMessage());
        notifySubscriber(session.getId());
    }

    // MEMO (2) -> 메모 1,2 정도를 제외하면 클라이언트 핸들러가 달라지는 경우는 없음 . -> 클래스 하나에 사용부분에서 다형적으로 type 설정만 해도 ?
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
