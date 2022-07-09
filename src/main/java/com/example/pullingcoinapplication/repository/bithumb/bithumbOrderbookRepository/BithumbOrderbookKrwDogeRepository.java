package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwChz;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwDogeRepository extends JpaRepository<BithumbOrderbookKrwDoge, Long>, BithumbOrderbookCommonJpaInterface {
}
