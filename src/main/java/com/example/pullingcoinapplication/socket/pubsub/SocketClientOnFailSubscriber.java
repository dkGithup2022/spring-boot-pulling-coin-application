package com.example.pullingcoinapplication.socket.pubsub;

public interface SocketClientOnFailSubscriber {
    public void notified(String key);
}
