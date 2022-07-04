package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwBtcRepository extends JpaRepository<UpbitCandleKrwBtc, Long>, UpbitCandleCommonJpaInterface {
}
