package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwMana;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwMaticRepository extends JpaRepository<BithumbCandleKrwMatic,Long>,BithumbCandleCommonJpaInterface {
}
