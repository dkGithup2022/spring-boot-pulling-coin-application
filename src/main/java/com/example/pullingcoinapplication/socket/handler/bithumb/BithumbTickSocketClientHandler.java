package com.example.pullingcoinapplication.socket.handler.bithumb;

import com.example.pullingcoinapplication.entity.bithumb.tick.message.BithumbSocketTickMessage;
import com.example.pullingcoinapplication.entity.bithumb.tick.BithumbTick;
import com.example.pullingcoinapplication.entity.bithumb.tick.BithumbTickFactory;
import com.example.pullingcoinapplication.service.bithumb.tick.BithumbTickService;
import com.example.pullingcoinapplication.socket.handler.WebSocketClientPublisherHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Slf4j
@Component
@RequiredArgsConstructor
public class BithumbTickSocketClientHandler extends WebSocketClientPublisherHandler {
    private final BithumbTickService bithumbTickService;
    private final ObjectMapper objectMapper;


    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String s = String.valueOf(message.getPayload());
        BithumbSocketTickMessage bithumbSocketTickMessage = objectMapper.readValue(s, BithumbSocketTickMessage.class);

        if (bithumbSocketTickMessage.getStatus() != null && bithumbSocketTickMessage.getStatus().equals("0000"))
            return;

        for (BithumbTick tick : bithumbSocketTickMessage.getContent().getList()) {
            tick.setTimestamp(tick.getContDtm().getTime());
            bithumbTickService.save(BithumbTickFactory.of(tick));
        }

    }
}
