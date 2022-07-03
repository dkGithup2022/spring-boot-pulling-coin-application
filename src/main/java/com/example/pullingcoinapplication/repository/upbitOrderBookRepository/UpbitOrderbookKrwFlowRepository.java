package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwFlowRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwFlow,Long> {
}
