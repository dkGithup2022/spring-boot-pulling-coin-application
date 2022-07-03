package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwEthRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwEth,Long> {
}
