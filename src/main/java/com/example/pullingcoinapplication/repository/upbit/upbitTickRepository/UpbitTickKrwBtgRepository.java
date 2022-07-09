package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;

import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwBtgRepository extends JpaRepository<UpbitTickKrwBtg, Long>, UpbitCommonJpaInterface {
        }