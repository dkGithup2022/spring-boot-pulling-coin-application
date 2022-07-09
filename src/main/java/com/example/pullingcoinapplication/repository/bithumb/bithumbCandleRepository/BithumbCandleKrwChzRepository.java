package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwBtg;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwChzRepository extends JpaRepository<BithumbCandleKrwChz,Long>,BithumbCandleCommonJpaInterface {
}
