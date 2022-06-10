package com.example.pullingcoinapplication.service.upbitSocketClient;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.Uri;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.entity.upbit.socket.SocketClientIndicator;
import com.example.pullingcoinapplication.service.orderbook.UpbitOrderBookService;
import com.example.pullingcoinapplication.service.tick.UpbitTickService;
import com.example.pullingcoinapplication.service.upbitRest.UpbitRestRequestService;
import com.example.pullingcoinapplication.socket.handler.SocketClientHandlerFactory;
import com.example.pullingcoinapplication.socket.handler.WebSocketClientPublisherHandler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Slf4j
@Setter(AccessLevel.PRIVATE)
@ToString
public class UpbitSocketClientBuilderImpl implements UpbitSocketClientBuilder {
    private final SocketClientHandlerFactory socketClientHandlerFactory;
    private final Map<TaskType, Map> taskMap;

    private final Map<TaskType, AbstractUpbitSocketClient> taskSocketMap;

    private final UpbitRestRequestService upbitRestRequestService;
    private final UpbitOrderBookService upbitOrderBookService;
    private final UpbitTickService upbitTickService;

    private URI uri;
    private Map<SocketClientIndicator, WebSocketSession> sessionMap;
    private WebSocketClientPublisherHandler socketHandler;
    private TaskType taskType;
    private VendorType vendorType;
    private List<UpbitCoinCode> codes;

    @Override
    public UpbitSocketClientBuilderImpl setType(TaskType taskType) {
        this.setTaskType(taskType);
        return this;
    }

    @Override
    public UpbitSocketClientBuilderImpl setVendor(VendorType vendorType) {
        this.setVendorType(vendorType);
        return this;
    }

    @Override
    public UpbitSocketClientBuilderImpl setCoinCodes(List<UpbitCoinCode> codes) {
        this.setCodes(codes);
        return this;
    }

    @Override
    public AbstractUpbitSocketClient initialize() {
        if (!isInitializable())
            throw new RuntimeException("missing arg : " + this.toString());
        try {
            this.uri = createUri();
            sessionMap = taskMap.get(taskType);
            AbstractUpbitSocketClient socketClient =  newSocketClient();
            registerTaskMap(socketClient);
            return socketClient;
        } catch (Exception e) {
            log.error("error on initializing handler ");
            throw new RuntimeException("error on initializing handler ");
        }
    }

    private boolean isInitializable() {
        return (isValidTaskType() && vendorType != null && codes != null);
    }

    private URI createUri() throws URISyntaxException {
        switch (vendorType) {
            case UPBIT:
                return new URI(Uri.UPBIT_SOCKET_URI.getAddress());
            case BITHUMB:
                throw new RuntimeException("this vendor is not ready ");
            default:
                throw new RuntimeException("invalid vendor ");
        }
    }

    private boolean isValidTaskType() {
        return (taskType != null && Arrays.asList(TaskType.values()).contains(taskType));
    }


    private ListenableFuture<WebSocketSession> newClientSession() {
        return new StandardWebSocketClient().doHandshake(socketHandler, null, uri);
    }


    private AbstractUpbitSocketClient newSocketClient() {
        AbstractUpbitSocketClient socketClient;
        if (taskType == TaskType.UPBIT_TICK) {
            socketClient = new UpbitTickSocketClient(
                    upbitRestRequestService,
                    uri,
                    taskMap.get(taskType),
                    socketClientHandlerFactory.getHandler(taskType, vendorType),
                    taskType,
                    vendorType,
                    codes,
                    upbitTickService
            );
        } else if (taskType == TaskType.UPBIT_ORDERBOOK) {
            socketClient = new UpbitOrderbookSocketClient(
                    upbitRestRequestService,
                    uri,
                    taskMap.get(taskType),
                    socketClientHandlerFactory.getHandler(taskType, vendorType),
                    taskType,
                    vendorType,
                    codes,
                    upbitOrderBookService
            );
        } else {
            throw new RuntimeException("invalid socket info");
        }
        return socketClient;
    }

    private void registerTaskMap(AbstractUpbitSocketClient socketClient){
        switch (socketClient.getTaskType()){
            case UPBIT_ORDERBOOK:
                taskSocketMap.put(TaskType.UPBIT_ORDERBOOK,socketClient);
                break;
            case UPBIT_TICK:
                taskSocketMap.put(TaskType.UPBIT_TICK,socketClient);
                break;
            default :
                throw new RuntimeException("task map match fail");
        }
    }

}
