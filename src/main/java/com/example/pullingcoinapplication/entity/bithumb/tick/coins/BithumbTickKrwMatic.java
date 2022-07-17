package com.example.pullingcoinapplication.entity.bithumb.tick.coins;

import com.example.pullingcoinapplication.entity.bithumb.tick.BithumbTick;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "bithumb_tick_krw_matic", indexes = {
        @Index(name = "bithumb_tick_krw_matic_index",  columnList="timestamp",unique = false)
})
public class BithumbTickKrwMatic extends BithumbTick {
}
