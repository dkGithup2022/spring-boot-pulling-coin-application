package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAvaxRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwAvax,Long> {
}
