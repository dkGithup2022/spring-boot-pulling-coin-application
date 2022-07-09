package com.example.pullingcoinapplication.util;


import com.example.pullingcoinapplication.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.example.pullingcoinapplication.exception.CoinDataException;
import com.example.pullingcoinapplication.exception.CoinDataExceptionCode;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


// TODO : 여기 에러처리가 이상함. -> 여기는 Throw 를 하는게 맞고, 이용자 단계에서 catch 를 하는 것이 맞아보임.
//         (메모하기!) 로직에서 여기서  catch 가 있다면, util 잡무 주제에 실행로직에 너무 큰 관여를 하는게 됨.
@Service
public class CodeUtil {

    // TODO : getUpbitCoinCode 로 수정
    public static UpbitCoinCode getCoinCodeFromString(String code) {
        code = replaceBarToUnderBar(code);
        if (isValidCoinCode(code)) {
            return UpbitCoinCode.valueOf(code);
        } else {
            throw new CoinDataException(CoinDataExceptionCode.INVALID_COIN_CODE);
        }
    }


    public static BithumbCoinCode getBithumbCoinCodeFromString(String code) {
        code = replaceBarToUnderBar(code);
        try{
            return BithumbCoinCode.valueOf(code);
        } catch(Exception e) {
            throw new CoinDataException(CoinDataExceptionCode.INVALID_COIN_CODE);
        }
    }


    private static boolean isValidCoinCode(String coinCode) {
        List<String> coinCodes = Arrays.asList(
                Arrays.stream(UpbitCoinCode.values())
                        .map(coinEnum -> coinEnum.name())
                        .toArray(String[]::new)
        );

        return coinCodes.contains(coinCode);
    }



    public static List<UpbitCoinCode> getAllCoinCodes(){
        return Arrays.asList(UpbitCoinCode.values());
    }

    private static String replaceBarToUnderBar(String str) {
        return str.replace("-", "_");
    }

}
