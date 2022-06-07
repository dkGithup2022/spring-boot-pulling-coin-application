package com.example.pullingcoinapplication.service.orderbook;

import com.example.pullingcoinapplication.entity.upbit.orderbook.OrderBookUnit;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbookPk;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;



@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class UpbitOrderBookServiceTest {

    @Autowired
    UpbitOrderBookService upbitOrderBookService;

    @Autowired
    ObjectMapper objectMapper;

    Random random = new Random();

    @Test
    void empty(){}

    @Test
    void save() throws JsonProcessingException {
        UpbitOrderbook upbitOrderbook = getNewOrderBook(10L,3);
        System.out.println(upbitOrderbook);
        upbitOrderBookService.save(upbitOrderbook);

        System.out.println(upbitOrderbook);

        UpbitOrderbook upbitOrderbook2 = upbitOrderBookService.findByPk(upbitOrderbook.getPk());

        assertEquals( upbitOrderbook, upbitOrderbook2);
    }

    @Test
    void saveDuplicate() throws JsonProcessingException {
        UpbitOrderbook upbitOrderbook = getNewOrderBook(10L,3);
        System.out.println(upbitOrderbook);
        upbitOrderBookService.save(upbitOrderbook);
        upbitOrderBookService.save(upbitOrderbook);
        upbitOrderBookService.save(upbitOrderbook);

        assertEquals(1,upbitOrderBookService.findAll().size());
    }

    @Test
    void findByPk() throws JsonProcessingException {
        UpbitOrderbook upbitOrderbook = getNewOrderBook(10L,3);

        upbitOrderBookService.save(upbitOrderbook);
        UpbitOrderbook upbitOrderbook2 = upbitOrderBookService.findByPk(upbitOrderbook.getPk());

        assertEquals( upbitOrderbook, upbitOrderbook2);

    }

    public UpbitOrderbook getNewOrderBook(Long timestamp, int count) throws JsonProcessingException {
        Long tsTimestamp = timestamp;
        String market = String.valueOf(tsTimestamp);
        ArrayList<OrderBookUnit> units = new ArrayList<>();

        for(int i =0; i< count ; i++)
            units.add(getNewOrderBookUnit());

        return new UpbitOrderbook(market,tsTimestamp,random.nextDouble(),random.nextDouble(),objectMapper.writeValueAsString(units));

    }

    public OrderBookUnit getNewOrderBookUnit(){
        return new OrderBookUnit(random.nextDouble(),random.nextDouble(),random.nextDouble(), random.nextDouble());
    }

}