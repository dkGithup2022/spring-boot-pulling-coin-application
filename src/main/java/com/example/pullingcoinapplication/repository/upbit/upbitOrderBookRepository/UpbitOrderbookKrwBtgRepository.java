package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwBtgRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwBtg,Long> {
}
