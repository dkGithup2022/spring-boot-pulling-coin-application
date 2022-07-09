package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwSrmRepository extends JpaRepository<UpbitCandleKrwSrm, Long>,UpbitCandleCommonJpaInterface {
}
