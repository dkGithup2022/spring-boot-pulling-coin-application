package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;

import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwDotRepository extends JpaRepository<UpbitTickKrwDot, Long>, UpbitCommonJpaInterface {
}

