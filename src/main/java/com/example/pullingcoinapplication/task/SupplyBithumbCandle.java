package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.example.pullingcoinapplication.entity.bithumb.candle.BithumbCandle;
import com.example.pullingcoinapplication.entity.bithumb.candle.BithumbCandleFactory;
import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandle;
import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandleFactory;
import com.example.pullingcoinapplication.service.bithumb.candle.BithumbCandleService;
import com.example.pullingcoinapplication.service.restCall.bithumbRest.BithumbRestRequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class SupplyBithumbCandle {

    private final BithumbRestRequestService bithumbRestRequestService;
    private final BithumbCandleService bithumbCandleService;

    @Scheduled(cron = "${property.upbitCron.candle.period.cronCommand}")
    public void bithumbCandleSupply() throws IOException, InterruptedException {
        log.info(" bithumbCandleSupply()  | timestamp : {} |  start supply bithumb candle data",System.currentTimeMillis() );
        for(BithumbCoinCode code : BithumbCoinCode.values()){
            Thread.sleep(bithumbRestRequestService.getSleepMillis());
            log.info("  bithumbCandleSupply()  | timestamp : {} |  supply candle : {}", System.currentTimeMillis(),code.toString() );
            List<BithumbCandle> candles = bithumbRestRequestService.getLastestCandles(code);
            candles.stream().forEach(c -> bithumbCandleService.safeSave(BithumbCandleFactory.of(c)));
        }
    }
}
