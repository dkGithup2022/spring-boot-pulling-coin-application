package com.example.pullingcoinapplication.service;


import com.example.pullingcoinapplication.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.service.restCall.upbitRest.UpbitRestRequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UpbitRestRequestServiceTest {

    @Autowired
    private UpbitRestRequestService upbitRestRequestService;

    @Test
    public void getLatestBtcTick() throws JsonProcessingException {
        assertEquals( upbitRestRequestService.getLastestTicks(UpbitCoinCode.KRW_BTC).size(),100);
    }

}
