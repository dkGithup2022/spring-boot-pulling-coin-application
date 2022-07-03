package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwSandRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwSand,Long> {
}
