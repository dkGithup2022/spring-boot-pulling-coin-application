package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;


import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwBatRepository extends JpaRepository<UpbitCandleKrwBat, Long>, UpbitCandleCommonJpaInterface {
}
