package com.example.pullingcoinapplication.entity.bithumb.candle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BithumbCandle {

    public BithumbCandle(String code, Long timestamp, Double openingPrice, Double closingPrice, Double highPrice, Double lowPrice, Double tradeAmount) {
        this.code = code;
        this.timestamp = timestamp;
        this.openingPrice = openingPrice;
        this.closingPrice = closingPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.tradeAmount = tradeAmount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Transient
    private String code;

    @Column(name = "timestamp")
    public Long timestamp;

    @Column(name = "opening_price")
    private Double openingPrice;

    @Column(name = "closing_price")
    private Double closingPrice;

    @Column(name = "high_price")
    private Double highPrice;

    @Column(name = "low_price")
    private Double lowPrice;

    @Column(name = "trade_amount")
    private Double tradeAmount;
}
