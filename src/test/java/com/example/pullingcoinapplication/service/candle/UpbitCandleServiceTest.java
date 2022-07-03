package com.example.pullingcoinapplication.service.candle;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandle;
import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandleFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class UpbitCandleServiceTest {

    @Autowired
    private UpbitCandleService upbitCandleService;

    @Test
    public void empty(){}


    @Test
    public void testSave(){
        UpbitCandle candle = new UpbitCandle();
        candle.setMarket("KRW-BTC");
        candle.setTimestamp(3L);
        upbitCandleService.save(UpbitCandleFactory.of(candle));
        UpbitCandle candle2 = upbitCandleService.findOneByMarketAndTimestamp(UpbitCoinCode.KRW_BTC,3L);
        assertEquals(candle2,candle);
    }

}