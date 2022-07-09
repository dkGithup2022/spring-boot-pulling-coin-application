package com.example.pullingcoinapplication.socket.socketClient;

import com.example.pullingcoinapplication.constants.coinCode.CoinCode;
import com.example.pullingcoinapplication.constants.Uri;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.constants.vendor.VendorType;
import com.example.pullingcoinapplication.service.bithumb.orderbook.BithumbOrderbookService;
import com.example.pullingcoinapplication.service.bithumb.tick.BithumbTickService;
import com.example.pullingcoinapplication.socket.socketClient.bithumb.BithumbOrderbookSocketClient;
import com.example.pullingcoinapplication.socket.socketClient.bithumb.BithumbTickSocketClient;
import com.example.pullingcoinapplication.socket.socketClient.upbit.UpbitOrderbookSocketClient;
import com.example.pullingcoinapplication.socket.socketClient.upbit.UpbitTickSocketClient;
import com.example.pullingcoinapplication.service.upbit.orderbook.UpbitOrderBookService;
import com.example.pullingcoinapplication.service.upbit.tick.UpbitTickService;
import com.example.pullingcoinapplication.service.restCall.upbitRest.UpbitRestRequestService;
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
public class SocketClientBuilderImpl implements SocketClientBuilder {
    private final SocketClientHandlerFactory socketClientHandlerFactory;
    private final Map<TaskType, AbstractSocketClient> taskSocketMap;

    private final UpbitRestRequestService upbitRestRequestService;
    private final UpbitOrderBookService upbitOrderBookService;
    private final UpbitTickService upbitTickService;

    private final BithumbOrderbookService bithumbOrderbookService;
    private final BithumbTickService bithumbTickService;

    private URI uri;
    private WebSocketClientPublisherHandler socketHandler;
    private TaskType taskType;
    private VendorType vendorType;
    private List<CoinCode> codes;

    @Override
    public SocketClientBuilderImpl setType(TaskType taskType) {
        this.setTaskType(taskType);
        return this;
    }

    @Override
    public SocketClientBuilderImpl setVendor(VendorType vendorType) {
        this.setVendorType(vendorType);
        return this;
    }

    @Override
    public SocketClientBuilderImpl setCoinCodes(List<CoinCode> codes) {
        this.setCodes(codes);
        return this;
    }

    @Override
    public AbstractSocketClient initialize() {
        if (!isInitializable())
            throw new RuntimeException("missing arg : " + this.toString());
        try {
            this.uri = createUri();
            AbstractSocketClient socketClient = newSocketClient();
            registerTaskMap(socketClient);
            return socketClient;
        } catch (Exception e) {
            log.error("error on initializing handler \n error : {}",e);
            throw new RuntimeException("error on initializing handler ");
        }
    }

    private boolean isInitializable() {
        return (isValidTaskType() && vendorType != null && codes != null);
    }

    private boolean isValidTaskType() {
        return (taskType != null && Arrays.asList(TaskType.values()).contains(taskType));
    }

    private URI createUri() throws URISyntaxException {
        switch (vendorType) {
            case UPBIT:
                return new URI(Uri.UPBIT_SOCKET_URI.getAddress());
            case BITHUMB:
                return new URI(Uri.BITHUMB_SOCKET_URI.getAddress());
            default:
                throw new RuntimeException("invalid vendor ");
        }
    }

    private ListenableFuture<WebSocketSession> newClientSession() {
        return new StandardWebSocketClient().doHandshake(socketHandler, null, uri);
    }

    private AbstractSocketClient newSocketClient() {
        AbstractSocketClient socketClient;
        if (taskType == TaskType.UPBIT_TICK) {
            socketClient = new UpbitTickSocketClient(
                    upbitRestRequestService,
                    uri,
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
                    socketClientHandlerFactory.getHandler(taskType, vendorType),
                    taskType,
                    vendorType,
                    codes,
                    upbitOrderBookService
            );
        } else if (taskType == TaskType.BITHUMB_TICK) {
            socketClient = new BithumbTickSocketClient(
                    uri,
                    socketClientHandlerFactory.getHandler(taskType, vendorType),
                    taskType,
                    vendorType,
                    codes,
                    bithumbTickService
            );
        }
        else if (taskType == TaskType.BITHUMB_ORDERBOOK) {
            socketClient = new BithumbOrderbookSocketClient(
                    uri,
                    socketClientHandlerFactory.getHandler(taskType, vendorType),
                    taskType,
                    vendorType,
                    codes,
                    bithumbOrderbookService
            );
        }
        else {
            throw new RuntimeException("invalid socket info");
        }
        return socketClient;
    }

    private void registerTaskMap(AbstractSocketClient socketClient) {
        switch (socketClient.getTaskType()) {
            case UPBIT_ORDERBOOK:
                taskSocketMap.put(TaskType.UPBIT_ORDERBOOK, socketClient);
                break;
            case UPBIT_TICK:
                taskSocketMap.put(TaskType.UPBIT_TICK, socketClient);
                break;
            case BITHUMB_TICK:
                taskSocketMap.put(TaskType.BITHUMB_TICK, socketClient);
                break;
            case BITHUMB_ORDERBOOK:
                taskSocketMap.put(TaskType.BITHUMB_ORDERBOOK, socketClient);
                break;
            default:
                throw new RuntimeException("task map match fail");
        }
    }

}
