package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwPlaRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwPla,Long> {
}
