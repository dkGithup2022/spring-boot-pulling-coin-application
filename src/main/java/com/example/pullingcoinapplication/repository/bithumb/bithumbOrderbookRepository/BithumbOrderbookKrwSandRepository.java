package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwMatic;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwSandRepository extends JpaRepository<BithumbOrderbookKrwSand, Long>, BithumbOrderbookCommonJpaInterface {
}
