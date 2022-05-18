package com.example.pullingcoinapplication.entity.upbit.upbitTick;

import com.example.pullingcoinapplication.entity.upbit.CallType;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Data
@Getter
@Setter
@IdClass(UpbitTickPk.class)
public class UpbitTick {

    @Id
    @NotNull
    @JsonProperty("sid")
    @JsonAlias("sequential_id")
    private Long sequentialId;

    @Id
    @JsonProperty("cd")
    @JsonAlias({"code","market"})
    private String code;

    @JsonProperty("ty")
    @JsonAlias("type")
    private String type;

    @JsonProperty("tp")
    @JsonAlias("trade_price")
    private Double tradePrice;

    @JsonProperty("tv")
    @JsonAlias("trade_volume")
    private Double tradeVolume;

    @JsonProperty("ab")
    @JsonAlias("ask_bid")
    private String askBid;

    @JsonProperty("pcp")
    @JsonAlias("prev_closing_price")
    private Double prev_closing_price;

    @JsonProperty("c")
    @JsonAlias("change")
    private String change;

    @JsonProperty("cp")
    @JsonAlias("change_price")
    private Double change_price;

    @JsonProperty("td")
    @JsonAlias({"trade_date","trade_date_utc"})
    private String tradeDateUtc;

    @JsonProperty("ttm")
    @JsonAlias({"trade_time","trade_time_utc"})
    private String tradeTimeUtc;

    @JsonProperty("ttms")
    @JsonAlias("trade_timestamp")
    private Long tradeTimestamp;

    @JsonProperty("tms")
    @JsonAlias("timestamp")
    private Long timestamp;

    @JsonProperty("st")
    @JsonAlias("stream_type")
    private String streamType;

    private CallType callType;
}
