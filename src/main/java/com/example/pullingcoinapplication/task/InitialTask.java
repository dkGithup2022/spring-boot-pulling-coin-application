package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.Uri;
import com.example.pullingcoinapplication.service.upbitSocketClient.UpbitSocketClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitialTask implements ApplicationRunner {
    private final UpbitSocketClientService upbitSocketClientService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        testrun();
    }

    public void testrun() throws Exception{
        upbitSocketClientService.runSocketClientListener(
                new URI(Uri.UPBIT_SOCKET_URI.getAddress()),
                UpbitCoinCode.values()
        );
    }
}


/*
    TODO :
        1) 리스너 등록 enum 으로
        2) 소켓 런하는 함수 전부 배열로.

 */