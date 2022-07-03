package com.example.pullingcoinapplication.entity.upbit.tick;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpbitTickPk implements Serializable {
    private Long sequentialId;
    private String code;
}
