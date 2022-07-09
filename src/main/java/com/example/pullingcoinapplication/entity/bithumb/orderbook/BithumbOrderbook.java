package com.example.pullingcoinapplication.entity.bithumb.orderbook;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BithumbOrderbook {

    @Id
    @JsonProperty("datetime")
    @Column(name = "datetime")
    private Long datetime;

    @JsonProperty("code")
    @JsonAlias("symbol")
    @Column(name = "code")
    private String code;
/*
    @JsonProperty("orderbookUnit")
    @Column(name = "orderbook_unit")
    @Lob
    private List<BithumbOrderbookUnit> orderbookUnits;
 */

}
