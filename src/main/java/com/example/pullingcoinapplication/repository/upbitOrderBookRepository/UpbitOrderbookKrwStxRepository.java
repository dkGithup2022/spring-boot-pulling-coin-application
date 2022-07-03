package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwStx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwStxRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwStx,Long> {
}
