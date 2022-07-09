package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwManaRepository extends JpaRepository<BithumbCandleKrwMana,Long>,BithumbCandleCommonJpaInterface {
}
