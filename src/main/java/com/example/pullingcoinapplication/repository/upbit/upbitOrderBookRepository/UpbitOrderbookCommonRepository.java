package com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository;


import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;

import java.util.List;

public interface UpbitOrderbookCommonRepository{
    UpbitOrderbook save(UpbitOrderbook upbitOrderbook);
    UpbitOrderbook findOneByTimestamp(Long timestamp);
}
