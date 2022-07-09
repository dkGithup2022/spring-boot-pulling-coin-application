package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwEtc;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwEthRepository extends JpaRepository<BithumbOrderbookKrwEth, Long>, BithumbOrderbookCommonJpaInterface {
}
