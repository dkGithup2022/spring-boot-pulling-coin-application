package com.example.pullingcoinapplication.repository.upbitOrderBookRepository;


import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbookPk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UpbitOrderbookRepository extends JpaRepository<UpbitOrderbook,UpbitOrderbookPk>{

    UpbitOrderbook save (UpbitOrderbook upbitOrderbook);
    List<UpbitOrderbook> findAll ();
    UpbitOrderbook findByMarketAndTimestamp(String market, Long timestamp);
}
