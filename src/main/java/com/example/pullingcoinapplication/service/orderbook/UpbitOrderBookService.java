package com.example.pullingcoinapplication.service.orderbook;


import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbookPk;
import com.example.pullingcoinapplication.repository.upbitOrderBookRepository.UpbitOrderbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpbitOrderBookService {
    private final UpbitOrderbookRepository upbitOrderBookRepository;

    @Transactional
    public void safeSave(UpbitOrderbook upbitOrderbook) {
        if ((this.findByPk(upbitOrderbook.getPk()) == null) ) {
            upbitOrderBookRepository.save(upbitOrderbook);
        }
        else {
            log.error("duplicated orderbook pk : {}",upbitOrderbook.getPk());
        }
    }

    @Transactional
    public void save(UpbitOrderbook upbitOrderbook) {
        upbitOrderBookRepository.save(upbitOrderbook);
    }

    public UpbitOrderbook findByPk(UpbitOrderbookPk upbitOrderbookPk) {
        UpbitOrderbook orderbook = upbitOrderBookRepository.findByMarketAndTimestamp(upbitOrderbookPk.getMarket(),upbitOrderbookPk.getTimestamp());

        return  orderbook;
    }

    public List<UpbitOrderbook> findAll(){
        return upbitOrderBookRepository.findAll();
    }

}
