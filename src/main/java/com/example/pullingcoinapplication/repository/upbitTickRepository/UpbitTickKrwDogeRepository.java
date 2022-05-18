package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwDogeRepository extends JpaRepository<UpbitTickKrwDoge, Long>, UpbitCommonJpaInterface {
        }