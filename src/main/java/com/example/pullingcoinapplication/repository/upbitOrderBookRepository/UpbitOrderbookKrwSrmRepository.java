package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwSrmRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwSrm,Long> {
}
