package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAvax;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwAxsRepository extends JpaRepository<BithumbOrderbookKrwAxs, Long>, BithumbOrderbookCommonJpaInterface {
}
