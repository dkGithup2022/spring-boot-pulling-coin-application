package com.example.pullingcoinapplication.entity.upbit.upbitTick.coins;

import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "upbit_table_krw_etc")
public class UpbitTickKrwEtc extends UpbitTick implements Serializable {
}
