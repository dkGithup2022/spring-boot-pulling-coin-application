package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderBookFactory;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;
import com.example.pullingcoinapplication.service.orderbook.UpbitOrderBookService;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitOrderbookSocketClient;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitSocketClientBuilderImpl;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitTickSocketClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitialTask implements ApplicationRunner {
    private final UpbitSocketClientBuilderImpl upbitSocketClientBuilder;

    private final UpbitOrderBookService upbitOrderBookService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        pullUpbitTicks();
        pullUptitOrderbook();

    }
    private void pullUpbitTicks() throws Exception {
        UpbitTickSocketClient upbitTickSocketClient = (UpbitTickSocketClient) upbitSocketClientBuilder
                .setCoinCodes(Arrays.asList(UpbitCoinCode.values()))
                .setType(TaskType.UPBIT_TICK)
                .setVendor(VendorType.UPBIT)
                .initialize();
        upbitTickSocketClient.runSocketClientListener();
    }

    private void pullUptitOrderbook() throws Exception {
        UpbitOrderbookSocketClient upbitOrderbookSocketClient = (UpbitOrderbookSocketClient) upbitSocketClientBuilder
                .setCoinCodes(Arrays.asList(UpbitCoinCode.values()))
                .setType(TaskType.UPBIT_ORDERBOOK)
                .setVendor(VendorType.UPBIT)
                .initialize();
        upbitOrderbookSocketClient.runSocketClientListener();
    }
}

