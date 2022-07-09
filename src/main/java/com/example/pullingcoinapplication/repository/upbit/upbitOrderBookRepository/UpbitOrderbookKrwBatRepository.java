package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwBatRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwBat,Long> {
}
