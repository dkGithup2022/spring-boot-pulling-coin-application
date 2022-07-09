package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwSand;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwSolRepository extends JpaRepository<BithumbOrderbookKrwSol, Long>, BithumbOrderbookCommonJpaInterface {
}
