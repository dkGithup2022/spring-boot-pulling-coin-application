package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwDotRepository extends JpaRepository<UpbitCandleKrwDot, Long>, UpbitCandleCommonJpaInterface {
}
