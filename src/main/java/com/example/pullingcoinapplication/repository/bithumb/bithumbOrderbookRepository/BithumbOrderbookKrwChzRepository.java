package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBtg;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwChzRepository extends JpaRepository<BithumbOrderbookKrwChz, Long>, BithumbOrderbookCommonJpaInterface {
}
