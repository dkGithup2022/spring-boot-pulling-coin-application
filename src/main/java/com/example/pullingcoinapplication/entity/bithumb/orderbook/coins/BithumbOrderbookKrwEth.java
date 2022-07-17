package com.example.pullingcoinapplication.entity.bithumb.orderbook.coins;


import com.example.pullingcoinapplication.entity.bithumb.orderbook.BithumbOrderbook;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "bithumb_orderbook_krw_eth",indexes = {
        @Index(name = "bithumb_orderbook_krw_eth_index",  columnList="datetime",unique = false)
})
public class BithumbOrderbookKrwEth extends BithumbOrderbook {
}
