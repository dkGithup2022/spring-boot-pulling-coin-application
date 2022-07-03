package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwPlaRepository extends JpaRepository<UpbitCandleKrwPla, Long>, UpbitCandleCommonJpaInterface {
}
