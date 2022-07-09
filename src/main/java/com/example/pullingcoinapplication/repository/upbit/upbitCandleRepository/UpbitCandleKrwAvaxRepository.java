package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;


import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAvaxRepository extends JpaRepository<UpbitCandleKrwAvax, Long>, UpbitCandleCommonJpaInterface {
}
