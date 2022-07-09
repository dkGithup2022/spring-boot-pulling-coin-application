package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwSol;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwSrmRepository extends JpaRepository<BithumbOrderbookKrwSrm, Long>, BithumbOrderbookCommonJpaInterface {
}
