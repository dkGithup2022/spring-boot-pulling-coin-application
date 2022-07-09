package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwBat;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwBchRepository extends JpaRepository<BithumbCandleKrwBch,Long>,BithumbCandleCommonJpaInterface {
}
