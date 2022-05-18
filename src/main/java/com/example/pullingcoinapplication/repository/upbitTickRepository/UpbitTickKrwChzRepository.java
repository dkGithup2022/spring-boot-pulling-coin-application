package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwChzRepository extends JpaRepository<UpbitTickKrwChz, Long>, UpbitCommonJpaInterface {
        }