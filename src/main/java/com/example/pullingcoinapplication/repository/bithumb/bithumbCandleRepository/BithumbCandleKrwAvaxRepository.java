package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwAtom;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwAvaxRepository extends JpaRepository<BithumbCandleKrwAvax,Long>,BithumbCandleCommonJpaInterface {
}
