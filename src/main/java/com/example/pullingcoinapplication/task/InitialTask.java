package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.Uri;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitOrderbookSocketClientService;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitSocketClientManager;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitTickSocketClientService;
import com.example.pullingcoinapplication.service.upbitSocketClient.d0610.UpbitOrderbookSocketClient;
import com.example.pullingcoinapplication.service.upbitSocketClient.d0610.UpbitSocketClientBuilderImpl;
import com.example.pullingcoinapplication.service.upbitSocketClient.d0610.UpbitTickSocketClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitialTask implements ApplicationRunner {
    private final UpbitTickSocketClientService upbitTickSocketClientService;
    private final UpbitOrderbookSocketClientService upbitOrderbookSocketClientService;
    private final UpbitSocketClientBuilderImpl upbitSocketClientBuilder;

    private final UpbitSocketClientManager upbitSocketClientManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        pullUpbitTicks();
        pullUptitOrderbook();
    }

    private void pullUpbitTicks() throws Exception{

        UpbitTickSocketClient upbitTickSocketClient = (UpbitTickSocketClient) upbitSocketClientBuilder
                .setCoinCodes(Arrays.asList(UpbitCoinCode.values()))
                .setType(TaskType.UPBIT_TICK)
                .setVendor(VendorType.UPBIT)
                .initialize();
        upbitTickSocketClient.runSocketClientListener();

    }


    private void pullUptitOrderbook() throws Exception{

        UpbitOrderbookSocketClient upbitOrderbookSocketClient = (UpbitOrderbookSocketClient) upbitSocketClientBuilder
                .setCoinCodes(Arrays.asList(UpbitCoinCode.values()))
                .setType(TaskType.UPBIT_ORDERBOOK)
                .setVendor(VendorType.UPBIT)
                .initialize();
        upbitOrderbookSocketClient.runSocketClientListener();
    }
}


/*
    TODO :
        1) 리스너 등록 enum 으로
        2) 소켓 런하는 함수 전부 배열로.

 */