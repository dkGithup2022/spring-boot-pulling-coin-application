package com.example.pullingcoinapplication.exception;

public class CoinDataException extends RuntimeException{
    private CoinDataExceptionCode code;
    private String message;

    public CoinDataException(CoinDataExceptionCode code){
        this(code, code.getMessage());
    }

    public CoinDataException(CoinDataExceptionCode code, String message) {
        super(message);
        this.code = code;
        this.message =  message;
    }
}
