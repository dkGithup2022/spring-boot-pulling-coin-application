package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandle;
import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandleFactory;
import com.example.pullingcoinapplication.service.upbit.candle.UpbitCandleService;
import com.example.pullingcoinapplication.service.restCall.upbitRest.UpbitRestRequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class SupplyUpbitCandle {

    private final UpbitRestRequestService upbitRestRequestService;
    private final UpbitCandleService upbitCandleService;

    @Scheduled(cron = "${property.upbitCron.candle.period.cronCommand}")
    public void upbitCandleSupply() throws JsonProcessingException, InterruptedException {
        Long current = System.currentTimeMillis();
        log.info("upbitCandleSupply | current time : {}", current);
        for (UpbitCoinCode code : UpbitCoinCode.values()) {
            upbitRestRequestService.pauseAfterRestRequest();
            List<UpbitCandle> candles = upbitRestRequestService.getMinutesCandles(code, current, 10);
            candles.stream().forEach(c -> upbitCandleService.safeSave(UpbitCandleFactory.of(c)));
        }
    }
}
