package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;


import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAxsRepository extends JpaRepository<UpbitCandleKrwAxs, Long>, UpbitCandleCommonJpaInterface {
}
