package com.example.pullingcoinapplication.entity.upbit.upbitTick.coins;


import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="upbit_tick_krw_sol")
public class UpbitTickKrwSol extends UpbitTick implements Serializable {
}
