package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwAxsRepository extends JpaRepository<UpbitTickKrwAxs, Long>, UpbitCommonJpaInterface {
        }
