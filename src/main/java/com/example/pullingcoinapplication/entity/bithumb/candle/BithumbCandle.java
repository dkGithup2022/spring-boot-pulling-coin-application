package com.example.pullingcoinapplication.entity.bithumb.candle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BithumbCandle {

    @Transient
    private String code;

    @Id
    @Column(name = "timestamp")
    public Long timestamp;

    @Column(name = "opening_price" )
    private Double openingPrice;

    @Column(name = "closing_price" )
    private Double closingPrice;

    @Column(name = "high_price")
    private Double highPrice;

    @Column(name = "low_price")
    private Double lowPrice;

    @Column(name = "trade_amount")
    private Double tradeAmount;



}