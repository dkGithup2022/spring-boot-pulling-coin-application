package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwAda;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwAtomRepository extends JpaRepository<BithumbCandleKrwAtom,Long>,BithumbCandleCommonJpaInterface {
}
