package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwEthRepository extends JpaRepository<UpbitCandleKrwEth, Long>, UpbitCandleCommonJpaInterface {
}
