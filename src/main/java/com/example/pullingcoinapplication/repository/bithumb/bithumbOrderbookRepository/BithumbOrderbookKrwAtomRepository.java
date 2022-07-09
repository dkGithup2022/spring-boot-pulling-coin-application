package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwAtomRepository extends JpaRepository<BithumbOrderbookKrwAtom, Long>, BithumbOrderbookCommonJpaInterface {
}
