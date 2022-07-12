package com.example.pullingcoinapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    // TODO 1) DB 접근 코드 에러 처리
    // TODO 2) 테스트코드 작성.
    // TODO 3) COINCODE 상속받게 바꿔서 이제 CODE UTIL 부분도 바꿔야함.
    // TODO 4) 빗썸 틱  키값 없음 -> rest & 소켓 다름 .
}
