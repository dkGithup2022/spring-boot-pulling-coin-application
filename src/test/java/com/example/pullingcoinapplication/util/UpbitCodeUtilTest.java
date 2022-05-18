package com.example.pullingcoinapplication.util;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.exception.CoinDataException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UpbitCodeUtilTest {

    @Autowired
    UpbitCodeUtil upbitCodeUtil;

    @Test
    public void convertCoinStringToCoinCode(){
        assertEquals(UpbitCoinCode.KRW_SOL, upbitCodeUtil.getCoinCodeFromString("KRW-SOL"));
        assertEquals(UpbitCoinCode.KRW_DOT, upbitCodeUtil.getCoinCodeFromString("KRW-DOT"));
        assertEquals(UpbitCoinCode.KRW_STX, upbitCodeUtil.getCoinCodeFromString("KRW-STX"));
    }


    // TODO: 테스트 패스하게 수정
    @Test(expected = CoinDataException.class)
    public void convertCoinStringToCoinCodeExpectException(){
       upbitCodeUtil.getCoinCodeFromString("nonono");
    }

}