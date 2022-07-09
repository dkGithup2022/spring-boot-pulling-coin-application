package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwDotRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwDot,Long> {
}
