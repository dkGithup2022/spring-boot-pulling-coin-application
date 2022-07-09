package com.example.pullingcoinapplication.socket.handler;

import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.socket.handler.bithumb.BithumbOrderbookSocketClientHandler;
import com.example.pullingcoinapplication.socket.handler.bithumb.BithumbTickSocketClientHandler;
import com.example.pullingcoinapplication.socket.handler.upbit.UpbitOrderBookSocketClientHandler;
import com.example.pullingcoinapplication.socket.handler.upbit.UpbitTickSocketClientHandler;
import com.example.pullingcoinapplication.socket.socketClient.bithumb.BithumbOrderbookSocketClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SocketClientHandlerFactory {
    private final UpbitOrderBookSocketClientHandler upbitOrderBookSocketClientHandler;
    private final UpbitTickSocketClientHandler upbitTickSocketClientHandler;
    private final BithumbTickSocketClientHandler bithumbTickSocketClientHandler;
    private final BithumbOrderbookSocketClientHandler bithumbOrderbookSocketClientHandler;

    public WebSocketClientPublisherHandler getHandler(TaskType taskType, VendorType vendorType){
        if(taskType == TaskType.UPBIT_ORDERBOOK && vendorType == VendorType.UPBIT){
            return upbitOrderBookSocketClientHandler;
        }
        else if(taskType == TaskType.UPBIT_TICK && vendorType == VendorType.UPBIT){
            return upbitTickSocketClientHandler;
        }
        else if(taskType == TaskType.BITHUMB_TICK && vendorType == VendorType.BITHUMB){
            return bithumbTickSocketClientHandler;
        }
        else if(taskType == TaskType.BITHUMB_ORDERBOOK && vendorType == VendorType.BITHUMB){
            return bithumbOrderbookSocketClientHandler;
        }
        else{
            throw new RuntimeException("invalid arg : "+ taskType +" , " + vendorType );

        }

    }

}
