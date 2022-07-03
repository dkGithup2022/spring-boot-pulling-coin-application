package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwBchRepository extends JpaRepository<UpbitCandleKrwBch, Long>, UpbitCandleCommonJpaInterface {
}
