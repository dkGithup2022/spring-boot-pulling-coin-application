package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwEnj;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwEtcRepository extends JpaRepository<BithumbCandleKrwEtc,Long>,BithumbCandleCommonJpaInterface {
}
