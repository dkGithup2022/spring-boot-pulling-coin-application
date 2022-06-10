package com.example.pullingcoinapplication.constants.vendor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VendorType {
    UPBIT("upbit"),
    BITHUMB("bithumb");

    public String name;
}
