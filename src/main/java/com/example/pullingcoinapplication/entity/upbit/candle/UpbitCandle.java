package com.example.pullingcoinapplication.entity.upbit.candle;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@MappedSuperclass
@ToString
@NoArgsConstructor
public class UpbitCandle implements Serializable {

    public UpbitCandle(Long timestamp,
                       String market,
                       Date candleDateTimeUtc,
                       Date candleDateTimeKst,
                       Double openingPrice,
                       Double highPrice,
                       Double lowPrice,
                       Double tradePrice,
                       Double candleAccTradePrice,
                       Double candleAccTradeVolume){

        this.timestamp = timestamp;
        this.market = market;
        this.candleDateTimeUtc = candleDateTimeUtc;
        this.candleDateTimeKst = candleDateTimeKst;
        this.openingPrice = openingPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.tradePrice=tradePrice;
        this.candleAccTradePrice = candleAccTradePrice;
        this.candleAccTradeVolume = candleAccTradeVolume;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @JsonProperty("timestamp")
    private Long timestamp;

    @NotNull
    @JsonProperty("cd")
    @JsonAlias({"code","market"})
    private String market;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("candle_date_time_utc")
    private  Date candleDateTimeUtc;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("candle_date_time_kst")
    private Date candleDateTimeKst;

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

}
