package com.example.pullingcoinapplication.socket.pubsub;

public interface SocketClientOnFailPublisher {
    void setSubscriber(SocketClientOnFailSubscriber subscriber);
    void notifySubscriber(String key);
}
