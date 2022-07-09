package com.example.pullingcoinapplication.entity.bithumb.orderbook;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
public class BithumbOrderbookUnit {

    @JsonProperty("orderType")
    @Column(name = "order_type")
    private String orderType;

    @JsonProperty("price")
    @Column(name = "price")
    private Double price;

    @JsonProperty("quantity")
    @Column(name = "quantity")
    private Double quantity;;

    @JsonProperty("total")
    @Column(name = "total")
    private Double total;

}
