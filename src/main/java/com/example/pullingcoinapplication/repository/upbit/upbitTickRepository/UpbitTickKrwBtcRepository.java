package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;

import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UpbitTickKrwBtcRepository extends JpaRepository<UpbitTickKrwBtc, Long>, UpbitCommonJpaInterface {
}