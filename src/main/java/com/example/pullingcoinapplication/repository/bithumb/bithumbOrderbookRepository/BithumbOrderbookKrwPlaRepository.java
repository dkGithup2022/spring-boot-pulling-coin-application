package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwPla;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwPlaRepository extends JpaRepository<BithumbOrderbookKrwPla, Long>, BithumbOrderbookCommonJpaInterface {
}
