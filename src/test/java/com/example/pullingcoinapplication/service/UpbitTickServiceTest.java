package com.example.pullingcoinapplication.service;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTickFactory;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTickPk;
import com.example.pullingcoinapplication.repository.upbitTickRepository.UpbitTickKrwDotRepository;
import com.example.pullingcoinapplication.service.upbitRest.UpbitRestRequestService;
import com.example.pullingcoinapplication.util.UpbitCodeUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpbitTickServiceTest {

    @Autowired
    UpbitTickService upbitTickService;

    @Autowired
    UpbitRestRequestService upbitRestRequestService;

    @Autowired
    UpbitTickFactory upbitTickFactory;

    @Autowired
    UpbitCodeUtil upbitCodeUtil;

    @Autowired
    UpbitTickKrwDotRepository upbitTickKrwDotRepository;

    @Test
    public void saveDotTick() {
        UpbitTick tick = new UpbitTick();
        tick.setSequentialId(1L);
        tick.setCode("KRW-DOT");

        upbitTickService.save(upbitTickFactory.of(
                tick,
                upbitCodeUtil.getCoinCodeFromString(tick.getCode())
                )
        );

        UpbitTick upbitTick = upbitTickService.findByPk(new UpbitTickPk(9L,"KRW-DOT"));

        System.out.println("**************************\n" + upbitTick + "\n*************************");
    }

    @Test
    public void saveWhenNotExist(){
        UpbitTick initialTick = new UpbitTick();
        initialTick.setSequentialId(1L);
        initialTick.setCode("KRW-DOT");
        initialTick.setStreamType("initial StreamType!");

        upbitTickService.save(upbitTickFactory.of(initialTick));
        System.out.println("initial : " + initialTick.toString());

        UpbitTick modifiedTick = new UpbitTick();
        modifiedTick.setSequentialId(1L);
        modifiedTick.setCode("KRW-DOT");
        modifiedTick.setStreamType("modified StreamType!");

        upbitTickService.saveWhenNotExist(modifiedTick);
        System.out.println("modified : " + modifiedTick);

        UpbitTick foundOne = upbitTickService.findByPk(new UpbitTickPk(1L,"KRW-DOT"));
        System.out.println("found one : " + foundOne);

        assertEquals(initialTick,foundOne);
    }


    @Test
    public void betweenQeuery() throws JsonProcessingException, InterruptedException {

        List<UpbitTick> ticks = upbitRestRequestService.getLastestTicks(UpbitCoinCode.KRW_BTC);
        for(UpbitTick tick : ticks) {
            upbitTickService.save(UpbitTickFactory.of(tick));
        }

        System.out.println(ticks);

        Thread.sleep(1000);

        Long now = System.currentTimeMillis();
        Long old = now - 1000*30; //30 초 전

        List<UpbitTick> list = upbitTickService.findByTimestampBetweenOrderByTimestampDesc(UpbitCoinCode.KRW_BTC,old,now);
        System.out.println(list.size());

        //Hibernate:
        // select code, sequential_id,.ask_bid ,...  from upbit_table_krw_btc where timestamp between ? and ? order by timestamp desc
    }


}