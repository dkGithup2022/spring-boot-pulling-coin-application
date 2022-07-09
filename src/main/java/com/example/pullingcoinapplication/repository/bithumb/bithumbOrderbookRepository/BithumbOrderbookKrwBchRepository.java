package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBat;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwBchRepository extends JpaRepository<BithumbOrderbookKrwBch, Long>, BithumbOrderbookCommonJpaInterface {
}
