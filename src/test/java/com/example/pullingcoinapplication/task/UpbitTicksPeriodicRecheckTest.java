package com.example.pullingcoinapplication.task;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.entity.upbit.tick.UpbitTick;
import com.example.pullingcoinapplication.service.tick.UpbitTickService;
import com.example.pullingcoinapplication.service.upbitRest.UpbitRestRequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UpbitTicksPeriodicRecheckTest {

    @Autowired
    UpbitTicksPeriodicRecheck upbitTicksPeriodicRecheck;

    @Autowired
    UpbitTickService upbitTickService;

    @Autowired
    UpbitRestRequestService upbitRestRequestService;

    @Test
    public void getRestTicksFor30Minutes() throws JsonProcessingException, InterruptedException {


        Long now = System.currentTimeMillis();
        Long oneHourBefore = now - 1000* 60 *30;
        // 2) 내 데이터 베이스에 30분전 것 까지 쿼리
        List<UpbitTick> tickBetween30Minutes =
                upbitTickService.findByTimestampBetweenOrderByTimestampDesc(UpbitCoinCode.KRW_BTC,oneHourBefore,now);

        List<UpbitTick> ticks = upbitRestRequestService.getTicksBetweenTimeStampFromRest(UpbitCoinCode.KRW_BTC,oneHourBefore, System.currentTimeMillis());
        log.info("now {} , 30min before : {}", now, oneHourBefore);
        log.info("list from db : {} | list from rest : {}" ,tickBetween30Minutes.size(), ticks.size() );
    }
}