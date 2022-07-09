package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwDogeRepository extends JpaRepository<UpbitCandleKrwDoge, Long>, UpbitCandleCommonJpaInterface {
}
