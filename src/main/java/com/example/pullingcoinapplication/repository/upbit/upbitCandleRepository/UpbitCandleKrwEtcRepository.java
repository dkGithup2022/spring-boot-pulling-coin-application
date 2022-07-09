package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwEtcRepository extends JpaRepository<UpbitCandleKrwEtc, Long>, UpbitCandleCommonJpaInterface {
}
