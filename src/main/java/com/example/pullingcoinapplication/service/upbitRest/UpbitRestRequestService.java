package com.example.pullingcoinapplication.service.upbitRest;

import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.constants.Uri;
import com.example.pullingcoinapplication.entity.upbit.CallType;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpbitRestRequestService {

    private final ObjectMapper objectMapper;


    //TODO : string builder
    public List<UpbitTick> getLastestTicks(UpbitCoinCode upbitCoinCode) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String uri = Uri.UPBIT_REST_TICK_URI.getAddress();
        uri += "?market=" + upbitCoinCode.toString();
        uri += "&count=100";
        System.out.println(uri);
        ResponseEntity<String> response
                = restTemplate.getForEntity(uri, String.class);

        List<UpbitTick> ticks = Arrays.asList(objectMapper.readValue(response.getBody(), UpbitTick[].class));
        ticks.stream().forEach(t -> t.setCallType(CallType.RESTAPI));
        return ticks;
    }

    public UpbitTick[] getTicksBeforeSequentialId(UpbitCoinCode upbitCoinCode, Long sequentialId) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String uri = Uri.UPBIT_REST_TICK_URI.getAddress();
        uri += "?market=" + upbitCoinCode.toString();
        uri += "&count=200";
        uri += "&cursor=" + sequentialId;
        log.info("Call rest api :  {}", uri);
        ResponseEntity<String> response
                = restTemplate.getForEntity(uri, String.class);
        // 에러 처리 ... TOO many req
        return objectMapper.readValue(response.getBody(), UpbitTick[].class);

    }


    public void pauseAfterRestRequest() throws InterruptedException {
        Thread.sleep(200);
    }

    public List<UpbitTick> getTicksBetweenTimeStampFromRest(UpbitCoinCode code, Long from, long to) throws InterruptedException {
        List<UpbitTick> currentTicks = getTicksBeforeSequentialIdSafe(code, to * 1000);
        currentTicks = currentTicks.stream()
                .distinct()
                .sorted(Comparator.comparing(UpbitTick::getSequentialId))
                .collect(Collectors.toList());

        while (currentTicks.get(0).getSequentialId() > from * 1000) {
            List<UpbitTick> restTicks = getTicksBeforeSequentialIdSafe(code, currentTicks.get(0).getSequentialId());
            // TODO : error 처리 -> try catch 로 변경.
            if (restTicks.size() == 0) {
                log.error("on sequential id: {} & code : {} , return size = 0", currentTicks.get(0).getSequentialId(), code);
                break;
            }
            restTicks = restTicks.stream().sorted(Comparator.comparing(UpbitTick::getSequentialId)).collect(Collectors.toList());
            currentTicks = Stream.concat(restTicks.stream(), currentTicks.stream()).collect(Collectors.toList());
            pauseAfterRestRequest();
        }

        currentTicks = currentTicks.stream().filter(t -> t.getSequentialId() >= from * 1000).collect(Collectors.toList());
        return currentTicks;
    }


    private List<UpbitTick> getTicksBeforeSequentialIdSafe(UpbitCoinCode code, Long toSequentialId) throws HttpClientErrorException, InterruptedException {
        List<UpbitTick> restTicks = new ArrayList<>();
        try {
            restTicks = Arrays.asList(getTicksBeforeSequentialId(code, toSequentialId));
            pauseAfterRestRequest();
        } catch (HttpClientErrorException clientErrorException) {
            if (clientErrorException.getRawStatusCode() == 429) {
                Thread.sleep(2000);
                return getTicksBeforeSequentialIdSafe(code, toSequentialId);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return restTicks;
    }
}
