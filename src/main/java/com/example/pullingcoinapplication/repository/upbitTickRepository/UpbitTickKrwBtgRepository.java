package com.example.pullingcoinapplication.repository.upbitTickRepository;

import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwBtgRepository extends JpaRepository<UpbitTickKrwBtg, Long>, UpbitCommonJpaInterface {
        }