package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwSolRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwSol,Long> {
}
