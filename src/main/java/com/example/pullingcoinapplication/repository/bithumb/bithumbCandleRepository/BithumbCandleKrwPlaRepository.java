package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwPla;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwPlaRepository extends JpaRepository<BithumbCandleKrwPla,Long>,BithumbCandleCommonJpaInterface {
}
