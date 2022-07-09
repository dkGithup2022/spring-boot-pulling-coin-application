package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.socket.socketClient.bithumb.BithumbOrderbookSocketClient;
import com.example.pullingcoinapplication.socket.socketClient.bithumb.BithumbTickSocketClient;
import com.example.pullingcoinapplication.socket.socketClient.upbit.UpbitOrderbookSocketClient;
import com.example.pullingcoinapplication.socket.socketClient.SocketClientBuilderImpl;
import com.example.pullingcoinapplication.socket.socketClient.upbit.UpbitTickSocketClient;
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
    private final SocketClientBuilderImpl upbitSocketClientBuilder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        pullUpbitTicks();
        pullUptitOrderbook();
        pullBithumbTicks();
        pullBithumbOrderbooks();
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

    private void pullBithumbTicks() throws Exception {
        BithumbTickSocketClient bithumbTickSocketClient = (BithumbTickSocketClient) upbitSocketClientBuilder
                .setCoinCodes(Arrays.asList(BithumbCoinCode.values()))
                .setType(TaskType.BITHUMB_TICK)
                .setVendor(VendorType.BITHUMB)
                .initialize();
        bithumbTickSocketClient.runSocketClientListener();
    }
    private void pullBithumbOrderbooks() throws Exception {
        BithumbOrderbookSocketClient bithumbOrderbookSocketClient = (BithumbOrderbookSocketClient) upbitSocketClientBuilder
                .setCoinCodes(Arrays.asList(BithumbCoinCode.values()))
                .setType(TaskType.BITHUMB_ORDERBOOK)
                .setVendor(VendorType.BITHUMB)
                .initialize();
        bithumbOrderbookSocketClient.runSocketClientListener();
    }

}

