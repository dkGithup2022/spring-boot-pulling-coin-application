package com.example.pullingcoinapplication.entity.upbit.tick.coins;

import com.example.pullingcoinapplication.entity.upbit.tick.UpbitTick;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "upbit_tick_krw_btc", indexes = {
        @Index(name = "upbit_tick_krw_btc_index",  columnList="timestamp",unique = false)
})
public class UpbitTickKrwBtc extends UpbitTick implements Serializable {
}
