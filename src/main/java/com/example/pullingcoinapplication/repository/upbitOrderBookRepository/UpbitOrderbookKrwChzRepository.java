package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwChzRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwChz,Long> {
}
