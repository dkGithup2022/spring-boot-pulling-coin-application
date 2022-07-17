package com.example.pullingcoinapplication.entity.bithumb.tick.coins;

import com.example.pullingcoinapplication.entity.bithumb.tick.BithumbTick;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "bithumb_tick_krw_eth", indexes = {
        @Index(name = "bithumb_tick_krw_eth_index",  columnList="timestamp",unique = false)
})
public class BithumbTickKrwEth extends BithumbTick {
}
