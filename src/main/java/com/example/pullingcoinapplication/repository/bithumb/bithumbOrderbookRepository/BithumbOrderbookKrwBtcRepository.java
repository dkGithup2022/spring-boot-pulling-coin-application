package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBch;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwBtcRepository extends JpaRepository<BithumbOrderbookKrwBtc, Long>, BithumbOrderbookCommonJpaInterface {
}
