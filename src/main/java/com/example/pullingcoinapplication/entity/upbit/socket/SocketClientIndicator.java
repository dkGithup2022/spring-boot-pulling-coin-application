package com.example.pullingcoinapplication.entity.upbit.socket;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SocketClientIndicator {
    // List 로
    private UpbitCoinCode[] coins;
    private String sessionId;

    public String coinsToString(){
        String result = "";
        for (UpbitCoinCode code : coins){
            result += code.toString() + ",";
        }
        return result.substring(0,result.length()-1);
    }

    public UpbitCoinCode[] getCoins(){
        return coins;
    }
}
