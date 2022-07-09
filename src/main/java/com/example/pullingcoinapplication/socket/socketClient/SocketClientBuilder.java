package com.example.pullingcoinapplication.socket.socketClient;

import com.example.pullingcoinapplication.constants.coinCode.CoinCode;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;

import java.util.List;

public interface SocketClientBuilder {
    SocketClientBuilder setType(TaskType taskType);
    SocketClientBuilder setVendor(VendorType vendorType);
    SocketClientBuilder setCoinCodes(List<CoinCode> codes);
    AbstractSocketClient initialize();
}
