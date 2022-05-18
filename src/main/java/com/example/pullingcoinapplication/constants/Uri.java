package com.example.pullingcoinapplication.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Uri {
    UPBIT_SOCKET_URI("wss://api.upbit.com/websocket/v1"),
    UPBIT_REST_TICK_URI("https://api.upbit.com/v1/trades/ticks");

    private String address;
}
