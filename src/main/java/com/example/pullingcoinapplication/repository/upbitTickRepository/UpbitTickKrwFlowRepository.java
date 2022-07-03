package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwFlowRepository extends JpaRepository<UpbitTickKrwFlow, Long>, UpbitCommonJpaInterface {
        }