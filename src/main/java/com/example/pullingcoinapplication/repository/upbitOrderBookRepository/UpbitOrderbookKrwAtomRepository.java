package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAtomRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwAtom,Long> {
}
