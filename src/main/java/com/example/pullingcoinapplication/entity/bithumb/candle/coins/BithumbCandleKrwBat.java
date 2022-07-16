package com.example.pullingcoinapplication.entity.bithumb.candle.coins;

import com.example.pullingcoinapplication.entity.bithumb.candle.BithumbCandle;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "bithumb_candle_krw_bat", indexes = {
        @Index(name = "bithumb_candle_krw_bat_index",  columnList="timestamp",unique = false)
})
public class BithumbCandleKrwBat extends BithumbCandle {
}
