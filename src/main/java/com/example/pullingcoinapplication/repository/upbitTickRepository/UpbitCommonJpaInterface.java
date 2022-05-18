package com.example.pullingcoinapplication.repository.upbitTickRepository;

import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UpbitCommonJpaInterface {
    void save(UpbitTick upbitTick);

    UpbitTick findBySequentialId(Long sequentialId);

    List<UpbitTick> findByTimestampBetweenOrderByTimestampDesc(Long old, Long now);
}
