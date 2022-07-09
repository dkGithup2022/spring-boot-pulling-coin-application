package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAxs;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwBatRepository extends JpaRepository<BithumbOrderbookKrwBat, Long>, BithumbOrderbookCommonJpaInterface {
}
