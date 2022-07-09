package com.example.pullingcoinapplication.service.restCall.bithumbRest;

import com.example.pullingcoinapplication.constants.Uri;
import com.example.pullingcoinapplication.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.example.pullingcoinapplication.entity.bithumb.candle.BithumbCandle;
import com.example.pullingcoinapplication.entity.bithumb.candle.message.BithumbRestCandleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BithumbRestRequestService {
    private final ObjectMapper objectMapper;

    public int getSleepMillis() {return 1000;}


    public List<BithumbCandle> getLastestCandles(BithumbCoinCode code) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String uri  = Uri.BITHUMB_REST_CANDLE_URI.getAddress();
        uri+= "/" + code.toString();
        uri+= "/1m";
        ResponseEntity<String> response
                = restTemplate.getForEntity(uri, String.class);
        BithumbRestCandleMessage brcm =  objectMapper.readValue(response.getBody(),BithumbRestCandleMessage.class);
        Object[] candleData = brcm.getData();
        ArrayList<BithumbCandle> bithumbCandles = new ArrayList<BithumbCandle>();
        for(Object data : candleData){
            ArrayList<Object> numbericData = (ArrayList<Object>) data;
            BithumbCandle c = new BithumbCandle(
                    code.toString()
                    ,Long.valueOf(String.valueOf(numbericData.get(0)))
                    ,Double.valueOf(String.valueOf(numbericData.get(1)))
                    ,Double.valueOf(String.valueOf(numbericData.get(2)))
                    ,Double.valueOf(String.valueOf(numbericData.get(3)))
                    ,Double.valueOf(String.valueOf(numbericData.get(4)))
                    ,Double.valueOf(String.valueOf(numbericData.get(5)))
                    );
            bithumbCandles.add(c);
        }
        return bithumbCandles;
    }
}
