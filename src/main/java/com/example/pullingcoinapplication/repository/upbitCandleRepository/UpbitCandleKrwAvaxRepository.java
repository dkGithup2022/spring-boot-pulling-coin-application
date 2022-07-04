package com.example.pullingcoinapplication.repository.upbitCandleRepository;


import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAvaxRepository extends JpaRepository<UpbitCandleKrwAvax, Long>, UpbitCandleCommonJpaInterface {
}
