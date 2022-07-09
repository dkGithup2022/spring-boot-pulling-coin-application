package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwDoge;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwDotRepository extends JpaRepository<BithumbCandleKrwDot,Long>,BithumbCandleCommonJpaInterface {
}
