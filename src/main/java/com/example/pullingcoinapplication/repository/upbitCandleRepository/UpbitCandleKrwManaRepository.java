package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwManaRepository extends JpaRepository<UpbitCandleKrwMana, Long>,UpbitCandleCommonJpaInterface {
}
