package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwAvax;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwAxsRepository extends JpaRepository<BithumbCandleKrwAxs,Long>,BithumbCandleCommonJpaInterface {
}
