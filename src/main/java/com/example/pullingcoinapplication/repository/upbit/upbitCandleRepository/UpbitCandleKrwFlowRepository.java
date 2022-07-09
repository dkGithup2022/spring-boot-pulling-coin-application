package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwFlowRepository extends JpaRepository<UpbitCandleKrwFlow, Long>, UpbitCandleCommonJpaInterface {
}
