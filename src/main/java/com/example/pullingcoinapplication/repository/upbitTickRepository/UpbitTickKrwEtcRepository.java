package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwEtc;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwEtcRepository extends JpaRepository<UpbitTickKrwEtc, Long>, UpbitCommonJpaInterface {
}