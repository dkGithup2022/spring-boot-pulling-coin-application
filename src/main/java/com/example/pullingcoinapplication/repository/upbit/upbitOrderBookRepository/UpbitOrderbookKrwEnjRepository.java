package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwEnjRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwEnj,Long> {
}
