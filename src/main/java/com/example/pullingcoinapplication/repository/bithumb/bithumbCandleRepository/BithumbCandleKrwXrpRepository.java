package com.example.pullingcoinapplication.repository.bithumb.bithumbCandleRepository;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwSrm;
import com.example.pullingcoinapplication.entity.bithumb.candle.coins.BithumbCandleKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwXrpRepository extends JpaRepository<BithumbCandleKrwXrp,Long>,BithumbCandleCommonJpaInterface {
}
