package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwMaticRepository extends JpaRepository<UpbitTickKrwMatic, Long>, UpbitCommonJpaInterface {
        }