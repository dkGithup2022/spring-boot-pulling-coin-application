package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwSol;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwSrmRepository extends JpaRepository<BithumbCandleKrwSrm,Long>,BithumbCandleCommonJpaInterface {
}
