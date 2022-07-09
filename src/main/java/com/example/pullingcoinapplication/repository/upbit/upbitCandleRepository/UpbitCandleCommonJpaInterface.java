package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;


import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandle;

public interface UpbitCandleCommonJpaInterface {
    UpbitCandle save(UpbitCandle candle);
    UpbitCandle findOneByTimestamp(long timestamp);
}
