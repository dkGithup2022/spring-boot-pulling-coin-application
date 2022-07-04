package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwChzRepository extends JpaRepository<UpbitCandleKrwChz, Long>, UpbitCandleCommonJpaInterface {
}
