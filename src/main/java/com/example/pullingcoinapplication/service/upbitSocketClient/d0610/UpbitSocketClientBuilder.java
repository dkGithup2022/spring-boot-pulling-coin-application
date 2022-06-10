package com.example.pullingcoinapplication.service.upbitSocketClient.d0610;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitSocketClientManager;

import java.util.List;

public interface UpbitSocketClientBuilder {
    UpbitSocketClientBuilder setType(TaskType taskType);
    UpbitSocketClientBuilder setVendor(VendorType vendorType);
    UpbitSocketClientBuilder setCoinCodes(List<UpbitCoinCode> codes);
    AbstractUpbitSocketClient initialize();
}
