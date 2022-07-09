package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwDot;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwEnjRepository extends JpaRepository<BithumbCandleKrwEnj,Long>,BithumbCandleCommonJpaInterface {
}
