package com.example.pullingcoinapplication.socket.handler.bithumb;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.BithumbOrderbook;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.BithumbOrderbookFactory;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.message.BithumbOrderbookListMessage;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.message.BithumbOrderbookSocketMessage;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.message.BithumbOrderbookUnitMessage;
import com.example.pullingcoinapplication.service.bithumb.orderbook.BithumbOrderbookService;
import com.example.pullingcoinapplication.socket.handler.WebSocketClientPublisherHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class BithumbOrderbookSocketClientHandler  extends WebSocketClientPublisherHandler {
    private final BithumbOrderbookService bithumbOrderbookService;
    private final ObjectMapper objectMapper;

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String s = String.valueOf(message.getPayload());
        BithumbOrderbookSocketMessage bithumbOrderbookSocketMessage = objectMapper.readValue(s, BithumbOrderbookSocketMessage.class);
        if(bithumbOrderbookSocketMessage.getResmsg()!= null || bithumbOrderbookSocketMessage.getStatus() != null){
            if(bithumbOrderbookSocketMessage.getStatus().equals("0000"))
                log.info("bithumb client socket connected message : {}", s);
            else
                log.error("error on connection | reply : {}", s);
            return;
        }
        BithumbOrderbook bithumbOrderbook = parseBithumbOrderbookMessage(bithumbOrderbookSocketMessage);
        bithumbOrderbookService.save(BithumbOrderbookFactory.of(bithumbOrderbook));
    }

    public BithumbOrderbook parseBithumbOrderbookMessage( BithumbOrderbookSocketMessage bithumbOrderbookSocketMessage )  {
        BithumbOrderbookListMessage content = bithumbOrderbookSocketMessage.getContent();
        List<BithumbOrderbookUnitMessage> list = content.getList();
        Long datetime = content.getDatetime();
        return  new BithumbOrderbook(datetime, list.get(0).getCode());

    }
}
