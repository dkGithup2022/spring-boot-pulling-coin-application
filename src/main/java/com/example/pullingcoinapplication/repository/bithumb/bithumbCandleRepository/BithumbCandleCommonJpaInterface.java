package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.BithumbCandle;

public interface BithumbCandleCommonJpaInterface {
    BithumbCandle save(BithumbCandle bithumbCandle);
    BithumbCandle findOneByTimestamp(Long timestamp);
}
