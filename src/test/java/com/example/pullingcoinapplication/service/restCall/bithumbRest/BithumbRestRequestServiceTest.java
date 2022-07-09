package com.example.pullingcoinapplication.service.restCall.bithumbRest;

import com.example.pullingcoinapplication.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BithumbRestRequestServiceTest {

    @Autowired
    private BithumbRestRequestService bithumbRestRequestService;

    @Test
    public void empty(){}

    @Test
    public void getLastestCandles() throws IOException {
        bithumbRestRequestService.getLastestCandles(BithumbCoinCode.KRW_BTC);
    }
}