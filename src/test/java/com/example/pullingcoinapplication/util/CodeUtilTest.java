package com.example.pullingcoinapplication.util;

import com.example.pullingcoinapplication.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.exception.CoinDataException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeUtilTest {

    @Autowired
    CodeUtil codeUtil;

    @Test
    public void convertCoinStringToCoinCode(){
        assertEquals(UpbitCoinCode.KRW_SOL, codeUtil.getCoinCodeFromString("KRW-SOL"));
        assertEquals(UpbitCoinCode.KRW_DOT, codeUtil.getCoinCodeFromString("KRW-DOT"));
        assertEquals(UpbitCoinCode.KRW_STX, codeUtil.getCoinCodeFromString("KRW-STX"));
    }


    // TODO: 테스트 패스하게 수정
    @Test(expected = CoinDataException.class)
    public void convertCoinStringToCoinCodeExpectException(){
       codeUtil.getCoinCodeFromString("nonono");
    }

}