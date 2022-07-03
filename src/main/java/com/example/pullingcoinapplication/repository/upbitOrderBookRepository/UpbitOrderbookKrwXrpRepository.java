package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwXrpRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwXrp,Long> {
}
