package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwEthRepository extends JpaRepository<UpbitTickKrwEth, Long>, UpbitCommonJpaInterface {
        }