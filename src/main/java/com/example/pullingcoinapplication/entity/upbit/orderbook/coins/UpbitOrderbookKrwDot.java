package com.example.pullingcoinapplication.entity.upbit.orderbook.coins;


import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "upbit_orderbook_krw_dot", indexes = {
        @Index(name = "upbit_orderbook_krw_dot_index",  columnList="timestamp",unique = false)
})
public class UpbitOrderbookKrwDot extends UpbitOrderbook {
}
