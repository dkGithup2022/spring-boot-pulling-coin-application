package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwSandRepository extends JpaRepository<UpbitTickKrwSand, Long>, UpbitCommonJpaInterface {
        }