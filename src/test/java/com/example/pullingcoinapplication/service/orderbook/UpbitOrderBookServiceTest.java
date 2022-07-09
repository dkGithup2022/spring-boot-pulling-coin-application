package com.example.pullingcoinapplication.service.orderbook;

import com.example.pullingcoinapplication.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.entity.upbit.orderbook.OrderBookUnit;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderBookFactory;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;
import com.example.pullingcoinapplication.service.upbit.orderbook.UpbitOrderBookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;



@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Slf4j
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
        upbitOrderBookService.save(UpbitOrderBookFactory.of(upbitOrderbook));
        System.out.println(upbitOrderbook);
       // UpbitOrderbook upbitOrderbook2 = upbitOrderBookService.findByPk(upbitOrderbook.getPk());
      //  assertEquals( upbitOrderbook, upbitOrderbook2);
    }



    @Test
    void findByPk() throws JsonProcessingException {
        UpbitOrderbook upbitOrderbook = getNewOrderBook(10L,3);
        upbitOrderBookService.save(UpbitOrderBookFactory.of(upbitOrderbook));
        UpbitOrderbook upbitOrderbook2 = upbitOrderBookService.findByCodeAndTimestamp(UpbitCoinCode.KRW_BTC,10L);
        assertEquals(upbitOrderbook, upbitOrderbook2);
    }

    public UpbitOrderbook getNewOrderBook(Long timestamp, int count) throws JsonProcessingException {
        String market = String.valueOf(UpbitCoinCode.KRW_BTC);
        ArrayList<OrderBookUnit> units = new ArrayList<>();

        for(int i =0; i< count ; i++)
            units.add(getNewOrderBookUnit());

        return new UpbitOrderbook(market,timestamp,random.nextDouble(),random.nextDouble(),units);

    }

    public OrderBookUnit getNewOrderBookUnit(){
        return new OrderBookUnit(random.nextDouble(),random.nextDouble(),random.nextDouble(), random.nextDouble());
    }



}