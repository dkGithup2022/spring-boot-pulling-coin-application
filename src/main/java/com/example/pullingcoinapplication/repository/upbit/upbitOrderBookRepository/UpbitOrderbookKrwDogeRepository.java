package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwDogeRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwDoge,Long> {
}
