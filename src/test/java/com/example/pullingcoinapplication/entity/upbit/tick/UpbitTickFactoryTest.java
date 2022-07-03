package com.example.pullingcoinapplication.entity.upbit.tick;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwDot;
import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwSol;
import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwStx;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UpbitTickFactoryTest {
    @Autowired
    UpbitTickFactory upbitTickFactory;

    @Test
    public void convertKrwSol() {
        UpbitTick tick = new UpbitTick();
        tick.setSequentialId(1L);
        assertEquals(UpbitTickKrwSol.class, upbitTickFactory.of(tick, UpbitCoinCode.KRW_SOL).getClass());
    }

    @Test
    public void convertKrwDot() {
        UpbitTick tick = new UpbitTick();
        tick.setSequentialId(1L);
        assertEquals(UpbitTickKrwDot.class, upbitTickFactory.of(tick, UpbitCoinCode.KRW_DOT).getClass());
    }

    @Test
    public void convertKrwStx() {
        UpbitTick tick = new UpbitTick();
        tick.setSequentialId(1L);
        assertEquals(UpbitTickKrwStx.class, upbitTickFactory.of(tick, UpbitCoinCode.KRW_STX).getClass());
    }


}