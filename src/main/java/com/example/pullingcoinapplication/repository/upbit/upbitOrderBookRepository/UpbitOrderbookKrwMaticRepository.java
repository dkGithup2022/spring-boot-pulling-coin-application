package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwMaticRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwMatic,Long> {
}
