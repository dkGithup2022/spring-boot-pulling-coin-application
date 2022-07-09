package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.BithumbCandle;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwAdaRepository extends BithumbCandleCommonJpaInterface, JpaRepository<BithumbCandleKrwAda,Long> {
}
