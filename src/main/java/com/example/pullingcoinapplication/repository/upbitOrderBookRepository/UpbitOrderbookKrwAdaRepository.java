package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwAda;
import com.example.pullingcoinapplication.repository.upbitTickRepository.UpbitCommonJpaInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAdaRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwAda,Long> {
}
