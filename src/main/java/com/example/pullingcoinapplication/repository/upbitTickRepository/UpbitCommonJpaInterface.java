package com.example.pullingcoinapplication.repository.upbitTickRepository;

import com.example.pullingcoinapplication.entity.upbit.tick.UpbitTick;

import java.util.List;

public interface UpbitCommonJpaInterface {
    void save(UpbitTick upbitTick);

    UpbitTick findBySequentialId(Long sequentialId);
    List<UpbitTick> findByTimestampBetweenOrderByTimestampDesc(Long old, Long now);
}
