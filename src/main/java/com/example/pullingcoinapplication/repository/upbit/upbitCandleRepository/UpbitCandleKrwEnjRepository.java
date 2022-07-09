package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;


import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwEnjRepository extends JpaRepository<UpbitCandleKrwEnj, Long>, UpbitCandleCommonJpaInterface {
}
