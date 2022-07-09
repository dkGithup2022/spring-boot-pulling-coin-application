package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwEnj;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwEtcRepository extends JpaRepository<BithumbOrderbookKrwEtc, Long>, BithumbOrderbookCommonJpaInterface {
}
