package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwChz;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwDogeRepository extends JpaRepository<BithumbCandleKrwDoge,Long>,BithumbCandleCommonJpaInterface {
}
