package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwManaRepository extends JpaRepository<UpbitCandleKrwMana, Long>,UpbitCandleCommonJpaInterface {
}
