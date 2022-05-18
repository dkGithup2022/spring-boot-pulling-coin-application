package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwAda;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwAdaRepository extends JpaRepository<UpbitTickKrwAda, Long>, UpbitCommonJpaInterface {
}

