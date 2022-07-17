package com.example.pullingcoinapplication.entity.bithumb.tick.coins;

import com.example.pullingcoinapplication.entity.bithumb.tick.BithumbTick;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "bithumb_tick_krw_avax", indexes = {
        @Index(name = "bithumb_tick_krw_avax_index",  columnList="timestamp",unique = false)
})
public class BithumbTickKrwAvax extends BithumbTick {
}
