package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwDotRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwDot,Long> {
}
