package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwBtgRepository extends JpaRepository<UpbitCandleKrwBtg, Long>, UpbitCandleCommonJpaInterface {
}
