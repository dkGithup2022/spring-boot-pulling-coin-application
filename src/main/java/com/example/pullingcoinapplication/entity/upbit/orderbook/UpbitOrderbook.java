package com.example.pullingcoinapplication.entity.upbit.orderbook;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
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
@Entity(name = "upbit_orderbook")
@IdClass(UpbitOrderbookPk.class)
@AllArgsConstructor
@NoArgsConstructor
@TypeDef(name = "json", typeClass = JsonType.class)
public class UpbitOrderbook implements Serializable {

    @Id
    @NotNull
    @JsonProperty("market")
    @JsonAlias("code")
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
    @Type(type = "json")
    @Column(columnDefinition = "json")
    // TODO : 배포 전에 JSONB 형식으로 변경 ...  H2/postgres 동시에 JSON 으로 받을 수 있는 자료형 있나 확인.
    private List<OrderBookUnit> orderBookUnits;

    /*
    public void setOrderBookUnits(ArrayList<OrderBookUnit> orderBookUnits) throws JsonProcessingException {
        this.orderBookUnits = new ObjectMapper().writeValueAsString(orderBookUnits);
    }

    public void setOrderBookUnits(String orderBookUnits) {
        this.orderBookUnits = orderBookUnits;
    }
     */

    public UpbitOrderbookPk getPk() {
        return new UpbitOrderbookPk(market, timestamp);
    }
}
