package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwEtc;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKewEtcRepository extends JpaRepository<UpbitTickKrwEtc, Long>, UpbitCommonJpaInterface {
}