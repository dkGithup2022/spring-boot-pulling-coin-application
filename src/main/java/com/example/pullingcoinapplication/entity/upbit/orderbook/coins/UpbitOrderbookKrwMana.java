package com.example.pullingcoinapplication.entity.upbit.orderbook.coins;


import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "upbit_orderbook_krw_mana", indexes = {
        @Index(name = "upbit_orderbook_krw_mana_index",  columnList="timestamp",unique = false)
})
public class UpbitOrderbookKrwMana extends UpbitOrderbook {
}
