package com.example.pullingcoinapplication.entity.upbit.tick.coins;

import com.example.pullingcoinapplication.entity.upbit.tick.UpbitTick;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "upbit_tick_krw_bat", indexes = {
        @Index(name = "upbit_tick_krw_bat_index",  columnList="timestamp",unique = false)
})
public class UpbitTickKrwBat extends UpbitTick implements Serializable {
}
