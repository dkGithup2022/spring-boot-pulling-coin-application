package com.example.pullingcoinapplication.entity.upbit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public enum CallType {
    RESTAPI("REST"),
    SOCKET("SOCKET");
    private String description;
}
