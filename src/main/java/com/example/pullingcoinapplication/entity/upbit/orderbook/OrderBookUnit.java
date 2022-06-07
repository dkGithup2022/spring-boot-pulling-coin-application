package com.example.pullingcoinapplication.entity.upbit.orderbook;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OrderBookUnit implements Serializable {
    @JsonProperty("ask_price")
    private Double askPrice;
    @JsonProperty("bid_price")
    private Double bidPrice;

    @JsonProperty("ask_size")
    private Double askSize;
    @JsonProperty("bid_size")
    private Double bidSize;
}
