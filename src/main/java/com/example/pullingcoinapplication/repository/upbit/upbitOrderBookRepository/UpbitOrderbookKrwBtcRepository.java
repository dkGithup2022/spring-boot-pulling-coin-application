package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UpbitOrderbookKrwBtcRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwBtc,Long> {
}
