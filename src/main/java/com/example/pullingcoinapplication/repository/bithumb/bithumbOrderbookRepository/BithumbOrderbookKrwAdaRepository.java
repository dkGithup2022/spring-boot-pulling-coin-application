package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.BithumbOrderbook;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwAda;
import com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository.BithumbTickCommonJpaInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwAdaRepository extends JpaRepository<BithumbOrderbookKrwAda, Long>, BithumbOrderbookCommonJpaInterface {
}
