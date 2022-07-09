package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwChzRepository extends JpaRepository<UpbitTickKrwChz, Long>, UpbitCommonJpaInterface {
        }