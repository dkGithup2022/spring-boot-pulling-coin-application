package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwPlaRepository extends JpaRepository<UpbitTickKrwPla, Long>, UpbitCommonJpaInterface {
        }