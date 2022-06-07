package com.example.pullingcoinapplication.entity.upbit.orderbook;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Data
@Entity(name = "upbit_orderbook")
@IdClass(UpbitOrderbookPk.class)
@AllArgsConstructor
@NoArgsConstructor
public class UpbitOrderbook implements Serializable {

    @Id
    @NotNull
    @JsonProperty("market")
    private String market;

    @Id
    @NotNull
    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("total_ask_size")
    private Double totalAskSize;

    @JsonProperty("total_bid_size")
    private Double totalBidSize;

    @JsonProperty("orderbook_units")
    @Lob
    @Column(columnDefinition = "text")
    // TODO : 배포 전에 JSONB 형식으로 변경 ...  H2/postgres 동시에 JSON 으로 받을 수 있는 자료형 있나 확인.
    private String orderBookUnits;

    public void setOrderBookUnits(ArrayList<OrderBookUnit> orderBookUnits) throws JsonProcessingException {
        this.orderBookUnits = new ObjectMapper().writeValueAsString(orderBookUnits);
    }

    public void setOrderBookUnits(String orderBookUnits) {
        this.orderBookUnits = orderBookUnits;
    }

    public UpbitOrderbookPk getPk() {
        return new UpbitOrderbookPk(market, timestamp);
    }
}
