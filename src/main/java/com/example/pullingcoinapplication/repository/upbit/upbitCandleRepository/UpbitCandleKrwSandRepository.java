package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwSandRepository extends JpaRepository<UpbitCandleKrwSand, Long>, UpbitCandleCommonJpaInterface {
}
