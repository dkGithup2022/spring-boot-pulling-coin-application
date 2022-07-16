package com.example.pullingcoinapplication.entity.upbit.candle.coin;



import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandle;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "upbit_candle_krw_eth",indexes = {
        @Index(name = "upbit_candle_krw_eth_index",  columnList="timestamp",unique = false)
})
public class UpbitCandleKrwEth extends UpbitCandle {
}
