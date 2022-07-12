package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.coinCode.CoinCode;
import com.example.pullingcoinapplication.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.task.TaskType;
import com.example.pullingcoinapplication.entity.upbit.tick.UpbitTick;
import com.example.pullingcoinapplication.entity.upbit.tick.UpbitTickFactory;
import com.example.pullingcoinapplication.service.upbit.tick.UpbitTickService;
import com.example.pullingcoinapplication.service.restCall.upbitRest.UpbitRestRequestService;
import com.example.pullingcoinapplication.socket.socketClient.AbstractSocketClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.*;
import java.util.stream.Collectors;


@Component
@Slf4j
@RequiredArgsConstructor
public class DoublecheckUpbitTicks {
    private final UpbitRestRequestService upbitRestRequestService;
    private final UpbitTickService upbitTickService;
    private final Map<TaskType, AbstractSocketClient> taskSocketMap;

    //@Value("${property.upbitCron.tick.doubleCheck.period}")
    private int checkPeriod;


    // TODO : 이거 태스크 맵에서 리스트 가져오게 수정 .
    @Scheduled(cron = "${property.upbitCron.tick.doubleCheck.cronCommand}")
    public void stuffUpMissingTicks() throws JsonProcessingException, InterruptedException {
        log.info("stuff up every {} min", checkPeriod);
        for (CoinCode code : taskSocketMap.get(TaskType.UPBIT_TICK).getCodes()) {
            UpbitCoinCode upbitCoinCode = (UpbitCoinCode) code;
            log.info(" {},{} | start rechecking  : ", System.currentTimeMillis(), code.toString());
            Long to = System.currentTimeMillis();
            Long from = to - 1000 * 60 * checkPeriod;

            //(1)
            List<UpbitTick> ticksFromDb =
                    upbitTickService.findByTimestampBetweenOrderByTimestampDesc(upbitCoinCode, from, to);

            List<UpbitTick> ticksFromRestApi = upbitRestRequestService.getTicksBetweenTimeStampFromRest(upbitCoinCode, from, to);
            log.info("{} | try unsaved ticks on database  | call rest apis", code.toString());
            Set<Long> missingTicks = pickOutMissingTickIds(ticksFromDb, ticksFromRestApi);
            log.info("try save missing ticks ... : {}", code);

            List<UpbitTick> ticksToSave = ticksFromRestApi.stream()
                    .filter(t -> !missingTicks.contains(t))
                    .collect(Collectors.toList());
            ticksToSave.stream()
                    .forEach(t -> upbitTickService.saveWhenNotExist(UpbitTickFactory.of(t)));
        }
        log.info("done : UpbitRestTickStuffUp");
    }


    private Set<Long> pickOutMissingTickIds(List<UpbitTick> ticksFromDb, List<UpbitTick> ticksFromRestApi) {
        HashSet<Long> sequentialIdSet = new HashSet<>();
        ticksFromRestApi.stream().forEach(tickData -> sequentialIdSet.add(tickData.getSequentialId()));
        log.info("rest ticks count : {} | set count : {} | db count : {} ", ticksFromRestApi.size(), sequentialIdSet.size(), ticksFromDb.size());
        ticksFromDb.stream().forEach(tickFromdb -> sequentialIdSet.remove(tickFromdb.getSequentialId()));
        return sequentialIdSet;
    }

}

