package com.example.pullingcoinapplication.socket.handler;

import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SocketClientHandlerFactory {
    private final UpbitOrderBookSocketClientHandler upbitOrderBookSocketClientHandler;
    private final WebSocketClientHandler webSocketClientHandler;

    public WebSocketClientPublisherHandler getHandler(TaskType taskType, VendorType vendorType){
        if(taskType == TaskType.UPBIT_ORDERBOOK && vendorType == VendorType.UPBIT){
            return upbitOrderBookSocketClientHandler;
        }
        else if(taskType == TaskType.UPBIT_TICK && vendorType == VendorType.UPBIT){
            return webSocketClientHandler;
        }
        else{
            throw new RuntimeException("invalid arg : "+ taskType +" , " + vendorType );

        }

    }

}
