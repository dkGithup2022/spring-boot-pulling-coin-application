package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwEtcRepository extends JpaRepository<UpbitCandleKrwEtc, Long>, UpbitCandleCommonJpaInterface {
}
