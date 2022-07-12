package com.example.pullingcoinapplication.constants.socketReq;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReqType {
    TRADE("trade"), TICKER("ticker"), ORDERBOOL("orderbook"), REST("rest");
    private String type;
}
