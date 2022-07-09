package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAtom;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwAvaxRepository extends JpaRepository<BithumbOrderbookKrwAvax, Long>, BithumbOrderbookCommonJpaInterface {
}
