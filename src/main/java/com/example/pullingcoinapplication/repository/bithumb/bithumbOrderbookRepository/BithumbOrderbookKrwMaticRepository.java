package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwMana;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwMaticRepository extends JpaRepository<BithumbOrderbookKrwMatic, Long>, BithumbOrderbookCommonJpaInterface {
}
