package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwEtc;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwEthRepository extends JpaRepository<BithumbCandleKrwEth,Long>,BithumbCandleCommonJpaInterface {
}
