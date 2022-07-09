package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwManaRepository extends JpaRepository<BithumbOrderbookKrwMana, Long>, BithumbOrderbookCommonJpaInterface {
}
