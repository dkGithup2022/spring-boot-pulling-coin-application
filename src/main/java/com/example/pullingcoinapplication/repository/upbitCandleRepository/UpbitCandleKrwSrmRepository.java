package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwSrmRepository extends JpaRepository<UpbitCandleKrwSrm, Long>,UpbitCandleCommonJpaInterface {
}
