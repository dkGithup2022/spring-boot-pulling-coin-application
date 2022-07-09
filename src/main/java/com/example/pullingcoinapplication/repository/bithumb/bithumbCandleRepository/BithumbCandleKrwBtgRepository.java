package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwBtc;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwBtgRepository extends JpaRepository<BithumbCandleKrwBtg,Long>,BithumbCandleCommonJpaInterface {
}
