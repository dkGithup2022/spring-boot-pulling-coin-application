package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwBchRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwBch,Long> {
}
