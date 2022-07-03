package com.example.pullingcoinapplication.repository.upbitCandleRepository;


import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandle;

public interface UpbitCandleCommonJpaInterface {
    UpbitCandle save(UpbitCandle candle);
    UpbitCandle findOneByTimestamp(long timestamp);
}
