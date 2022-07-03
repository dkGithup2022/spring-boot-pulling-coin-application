package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwBatRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwBat,Long> {
}
