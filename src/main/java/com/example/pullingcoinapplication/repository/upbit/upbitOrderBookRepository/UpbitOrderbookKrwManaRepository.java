package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwManaRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwMana,Long> {
}
