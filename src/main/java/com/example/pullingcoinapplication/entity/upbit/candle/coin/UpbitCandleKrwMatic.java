package com.example.pullingcoinapplication.entity.upbit.candle.coin;


import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandle;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "upbit_candle_krw_matic",indexes = {
        @Index(name = "upbit_candle_krw_matic_index",  columnList="timestamp",unique = false)
})
public class UpbitCandleKrwMatic extends UpbitCandle {
}
