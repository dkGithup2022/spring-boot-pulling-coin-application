package com.example.pullingcoinapplication.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CoinDataExceptionCode {
    INVALID_COIN_CODE("잘못된 코인 코드"),
    EXCEPTION_DURING_CONVERTING("데이터 전환 중 에러"),
    DATA_NOT_FOUND("데이터 찾을 수 없음");

    private String message;
}
