package com.example.pullingcoinapplication.entity.upbit.orderbook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpbitOrderbookPk implements Serializable {
    private String market;
    private Long timestamp;
}
