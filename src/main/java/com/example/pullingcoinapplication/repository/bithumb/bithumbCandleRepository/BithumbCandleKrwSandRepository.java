package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwMatic;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwSandRepository extends JpaRepository<BithumbCandleKrwSand,Long>,BithumbCandleCommonJpaInterface {
}
