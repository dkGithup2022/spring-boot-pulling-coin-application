package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwAvaxRepository extends JpaRepository<UpbitTickKrwAvax, Long>, UpbitCommonJpaInterface {
        }