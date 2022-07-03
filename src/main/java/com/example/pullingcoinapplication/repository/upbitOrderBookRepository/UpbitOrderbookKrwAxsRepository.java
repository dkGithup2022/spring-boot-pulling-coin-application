package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAxsRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwAxs,Long> {
}
