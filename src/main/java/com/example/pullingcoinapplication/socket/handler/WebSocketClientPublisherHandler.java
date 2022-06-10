package com.example.pullingcoinapplication.socket.handler;

import com.example.pullingcoinapplication.socket.pubsub.SocketClientOnFailPublisher;
import com.example.pullingcoinapplication.socket.pubsub.SocketClientOnFailSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Slf4j
public abstract class WebSocketClientPublisherHandler implements WebSocketHandler, SocketClientOnFailPublisher {

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
    private boolean isInvalidClosing(CloseStatus closeStatus) {
        return closeStatus.getCode() != 1000 && closeStatus.getCode() != 1007;
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
