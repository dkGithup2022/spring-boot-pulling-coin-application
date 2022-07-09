package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwDoge;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwDotRepository extends JpaRepository<BithumbOrderbookKrwDot, Long>, BithumbOrderbookCommonJpaInterface {
}
