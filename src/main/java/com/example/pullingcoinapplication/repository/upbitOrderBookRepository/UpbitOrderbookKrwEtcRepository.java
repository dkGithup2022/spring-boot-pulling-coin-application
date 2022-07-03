package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwEtcRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwEtc,Long> {
}
