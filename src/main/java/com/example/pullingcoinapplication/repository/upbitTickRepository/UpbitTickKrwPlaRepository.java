package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwPlaRepository extends JpaRepository<UpbitTickKrwPla, Long>, UpbitCommonJpaInterface {
        }