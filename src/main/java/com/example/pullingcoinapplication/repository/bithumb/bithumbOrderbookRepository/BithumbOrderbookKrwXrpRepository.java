package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwSrm;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwXrpRepository extends JpaRepository<BithumbOrderbookKrwXrp, Long>, BithumbOrderbookCommonJpaInterface {
}
