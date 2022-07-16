package com.example.pullingcoinapplication.entity.upbit.orderbook;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class UpbitOrderbook implements Serializable {

    public UpbitOrderbook(String code, Long timestamp, Double totalAskSize , Double totalBidSize, List<OrderBookUnit> orderBookUnits){
        this.code = code;
        this.timestamp = timestamp;
        this.totalAskSize = totalAskSize;
        this.totalBidSize = totalBidSize;
        this.orderBookUnits = orderBookUnits;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @JsonProperty("market")
    @JsonAlias("code")
    private String code;

    @NotNull
    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("total_ask_size")
    private Double totalAskSize;

    @JsonProperty("total_bid_size")
    private Double totalBidSize;

    @JsonProperty("orderbook_units")
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private List<OrderBookUnit> orderBookUnits;

}
