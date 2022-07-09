package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwPlaRepository extends JpaRepository<UpbitCandleKrwPla, Long>, UpbitCandleCommonJpaInterface {
}
