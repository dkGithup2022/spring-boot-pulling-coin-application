package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBtc;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwBtgRepository extends JpaRepository<BithumbOrderbookKrwBtg, Long>, BithumbOrderbookCommonJpaInterface {
}
