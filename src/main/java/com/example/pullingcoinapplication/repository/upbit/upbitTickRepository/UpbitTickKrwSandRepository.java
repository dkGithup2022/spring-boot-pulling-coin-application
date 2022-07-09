package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwSandRepository extends JpaRepository<UpbitTickKrwSand, Long>, UpbitCommonJpaInterface {
        }