package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwSand;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwSolRepository extends JpaRepository<BithumbCandleKrwSol,Long>,BithumbCandleCommonJpaInterface {
}
