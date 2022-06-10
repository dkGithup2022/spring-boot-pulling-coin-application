package com.example.pullingcoinapplication.service.upbitSocketClient;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;

import java.util.List;

public interface UpbitSocketClientManager {
    UpbitSocketClientManager setType(TaskType taskType);
    UpbitSocketClientManager setVendor(VendorType vendorType);
    UpbitSocketClientManager setCoinCodes(List<UpbitCoinCode> codes);
    void initialize();
    void runSocketClientListener();
    void getRequiredWaitTime();
}
