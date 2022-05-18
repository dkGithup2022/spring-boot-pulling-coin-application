package com.example.pullingcoinapplication.constants.socketReq;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SocketReqType {
    TRADE("trade"),TICKER("ticker"),ORDERBOOL("orderbook");
    private String type;
}
