package com.example.pullingcoinapplication.entity.bithumb.orderbook;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class BithumbOrderbook {

    @Id
    @JsonProperty("datetime")
    @Column(name = "datetime")
    private Long datetime;

    @JsonProperty("code")
    @JsonAlias("symbol")
    @Column(name = "code")
    private String code;

    @JsonProperty("orderbookUnit")
    @Column(name = "orderbook_unit", columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private List<BithumbOrderbookUnit> orderbookUnits;
}
