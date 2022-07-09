package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwDot;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwEnjRepository extends JpaRepository<BithumbOrderbookKrwEnj, Long>, BithumbOrderbookCommonJpaInterface {
}
