package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwStx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwStxRepository extends JpaRepository<UpbitCandleKrwStx, Long>, UpbitCandleCommonJpaInterface {
}
