package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;

import com.example.pullingcoinapplication.entity.upbit.orderbook.coins.UpbitOrderbookKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAtomRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwAtom,Long> {
}
