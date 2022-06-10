package com.example.pullingcoinapplication.service.upbitSocketClient;

public interface SocketClient {
    public void runSocketClientListener();
    public int getRequiredWaitTime();
}
