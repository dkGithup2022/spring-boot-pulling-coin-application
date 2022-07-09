package com.example.pullingcoinapplication.repository.bithumb.bithumbOrderbookRepository;

import com.example.pullingcoinapplication.entity.bithumb.orderbook.BithumbOrderbook;

public interface BithumbOrderbookCommonJpaInterface {
    BithumbOrderbook save(BithumbOrderbook bithumbOrderbook);
    BithumbOrderbook findOneByDatetime(Long datetime);
}
