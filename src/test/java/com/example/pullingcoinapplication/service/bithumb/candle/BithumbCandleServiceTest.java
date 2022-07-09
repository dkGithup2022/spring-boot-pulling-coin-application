package com.example.pullingcoinapplication.service.bithumb.candle;

import com.example.pullingcoinapplication.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.example.pullingcoinapplication.entity.bithumb.candle.BithumbCandle;
import com.example.pullingcoinapplication.entity.bithumb.candle.BithumbCandleFactory;
import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BithumbCandleServiceTest {
    @Autowired
    BithumbCandleService bithumbCandleService;

    @Test
    public void empty(){}

    @Test
    public void save() {
        BithumbCandle c = new BithumbCandle("BTC_KRW",100L,(double) 0,(double) 0,(double) 0,(double) 0,(double) 0);
        BithumbCandle c1 =  bithumbCandleService.save(BithumbCandleFactory.of(c));
        assertEquals(c.getTimestamp(),c1.getTimestamp());
    }

    @Test
    public void findOneByTimestamp() {
        BithumbCandle c = new BithumbCandle("BTC_KRW",100L,(double) 0,(double) 0,(double) 0,(double) 0,(double) 0);
        BithumbCandle c1 =  bithumbCandleService.save(BithumbCandleFactory.of(c));
        BithumbCandle c2 = bithumbCandleService.findOneByCodeAndTimestamp(BithumbCoinCode.KRW_BTC, 100L);
        assertEquals(c2,c1);
    }
    @Test
    public void safeSave() {
        BithumbCandle c = new BithumbCandle("BTC_KRW",100L,(double) 0,(double) 0,(double) 0,(double) 0,(double) 0);
        BithumbCandle c_ = new BithumbCandle("BTC_KRW",100L,(double) 1,(double) 0,(double) 0,(double) 0,(double) 0);

        BithumbCandle c1 =  bithumbCandleService.save(BithumbCandleFactory.of(c));
        BithumbCandle c_1 =  bithumbCandleService.safeSave(BithumbCandleFactory.of(c_));

        System.out.println("c_ : " + c_);
        System.out.println("c_1 : " + c_1);

        assertEquals(c_1,null);
    }

    @Test
    public void safeSave2() {
        BithumbCandle c = new BithumbCandle("BTC_KRW",100L,(double) 0,(double) 0,(double) 0,(double) 0,(double) 0);
        BithumbCandle c_ = new BithumbCandle("BTC_KRW",200L,(double) 1,(double) 0,(double) 0,(double) 0,(double) 0);

        BithumbCandle c1 =  bithumbCandleService.save(BithumbCandleFactory.of(c));
        BithumbCandle c_1 =  bithumbCandleService.safeSave(BithumbCandleFactory.of(c_));

        System.out.println("c_ : " + c_);
        System.out.println("c_1 : " + c_1);

        assertEquals(c_.getTimestamp(),c_1.getTimestamp());
    }



}