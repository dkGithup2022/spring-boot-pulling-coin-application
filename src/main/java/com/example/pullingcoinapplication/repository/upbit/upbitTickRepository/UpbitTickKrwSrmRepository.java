package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UpbitTickKrwSrmRepository extends JpaRepository<UpbitTickKrwSrm, Long>, UpbitCommonJpaInterface {
        }