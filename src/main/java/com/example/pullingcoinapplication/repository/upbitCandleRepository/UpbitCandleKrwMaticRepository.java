package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwMaticRepository extends JpaRepository<UpbitCandleKrwMatic, Long>, UpbitCandleCommonJpaInterface {
}
