package com.example.pullingcoinapplication.entity.upbit.candle;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@Data
@MappedSuperclass
@ToString
@NoArgsConstructor
public class UpbitCandle implements Serializable {

    @Id
    @NotNull
    @JsonProperty("timestamp")
    private Long timestamp;

    @NotNull
    @JsonProperty("cd")
    @JsonAlias({"code","market"})
    private String market;

    @JsonProperty("candle_date_time_utc")
    private String candleDateTimeUtc;

    @JsonProperty("candle_date_time_kst")
    private String candleDateTimeKst;

    @JsonProperty("opening_price")
    private Double openingPrice;

    @JsonProperty("high_price")
    private Double highPrice;

    @JsonProperty("low_price")
    private Double lowPrice;

    @JsonProperty("trade_price")
    private Double tradePrice;

    @JsonProperty("candle_acc_trade_price")
    private Double candleAccTradePrice;

    @JsonProperty("candle_acc_trade_volume")
    private Double candleAccTradeVolume;

    @JsonProperty("prev_closing_price")
    private Double prevClosingPrice;

    @JsonProperty("change_price")
    private Double changePrice;

    @JsonProperty("change_rate")
    private Double changeRate;

    @JsonProperty("converted_trade_price")
    private Double convertedTradePrice;

}
