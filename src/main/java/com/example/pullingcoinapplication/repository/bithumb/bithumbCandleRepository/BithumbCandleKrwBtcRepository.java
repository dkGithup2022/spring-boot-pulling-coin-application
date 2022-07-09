package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwBch;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwBtcRepository extends JpaRepository<BithumbCandleKrwBtc,Long>,BithumbCandleCommonJpaInterface {
}
