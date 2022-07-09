package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwMaticRepository extends JpaRepository<UpbitTickKrwMatic, Long>, UpbitCommonJpaInterface {
        }