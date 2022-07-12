package com.example.pullingcoinapplication.entity.upbit.orderbook;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonType;
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


    @NotNull
    @JsonProperty("market")
    @JsonAlias("code")
    private String code;

    @Id
    @NotNull
    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("total_ask_size")
    private Double totalAskSize;

    @JsonProperty("total_bid_size")
    private Double totalBidSize;

    @JsonProperty("orderbook_units")
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<OrderBookUnit> orderBookUnits;

    /*
    public void setOrderBookUnits(ArrayList<OrderBookUnit> orderBookUnits) throws JsonProcessingException {
        this.orderBookUnits = new ObjectMapper().writeValueAsString(orderBookUnits);
    }

    public void setOrderBookUnits(String orderBookUnits) {
        this.orderBookUnits = orderBookUnits;
    }
     */

}
