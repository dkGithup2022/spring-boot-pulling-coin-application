package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAdaRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwAda,Long> {
}
