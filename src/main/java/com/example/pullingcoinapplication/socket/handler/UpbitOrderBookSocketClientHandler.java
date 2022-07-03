package com.example.pullingcoinapplication.socket.handler;



import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderBookFactory;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;
import com.example.pullingcoinapplication.entity.upbit.tick.UpbitTickFactory;
import com.example.pullingcoinapplication.service.orderbook.UpbitOrderBookService;
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
public class UpbitOrderBookSocketClientHandler extends WebSocketClientPublisherHandler {

    private final UpbitOrderBookService upbitOrderBookService;
    private final ObjectMapper objectMapper;

    // MEMO (1)
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String s = StandardCharsets.UTF_8.decode((ByteBuffer) message.getPayload()).toString();
        UpbitOrderbook book = UpbitOrderBookFactory.of( objectMapper.readValue(s, UpbitOrderbook.class));
        upbitOrderBookService.save(book);
    }


}
