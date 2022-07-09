package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwAxs;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwBatRepository extends JpaRepository<BithumbCandleKrwBat,Long>,BithumbCandleCommonJpaInterface {
}
