package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UpbitOrderbookKrwBtcRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwBtc,Long> {
}
