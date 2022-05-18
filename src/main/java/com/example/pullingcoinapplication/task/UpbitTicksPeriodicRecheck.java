package com.example.pullingcoinapplication.task;


import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTickFactory;
import com.example.pullingcoinapplication.service.UpbitTickService;
import com.example.pullingcoinapplication.service.upbitRest.UpbitRestRequestService;
import com.example.pullingcoinapplication.util.UpbitCodeUtil;
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
public class UpbitTicksPeriodicRecheck {
    private final UpbitRestRequestService upbitRestRequestService;
    private final UpbitTickService upbitTickService;

    @Value("${property.upbitCron.doubleCheck.period}")
    private int checkPeriod;


    @Scheduled(cron = "${property.upbitCron.doubleCheck.cronCommand}")
    public void stuffUpMissingTicks() throws JsonProcessingException, InterruptedException {

        log.info("stuff up every {} min",checkPeriod);
        for (UpbitCoinCode code : UpbitCodeUtil.getAllCoinCodes()) {

            log.info(" {},{} | start rechecking  : ", System.currentTimeMillis(), code.toString());
            Long to = System.currentTimeMillis();
            Long from = to - 1000 * 60 * checkPeriod;

            List<UpbitTick> ticksFromDb =
                    upbitTickService.findByTimestampBetweenOrderByTimestampDesc(code, from, to);

            List<UpbitTick> ticksFromRestApi = upbitRestRequestService.getTicksBetweenTimeStampFromRest(code, from, to);
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

