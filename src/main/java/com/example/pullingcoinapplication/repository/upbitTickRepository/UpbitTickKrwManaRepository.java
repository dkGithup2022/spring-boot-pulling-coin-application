package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwManaRepository extends JpaRepository<UpbitTickKrwMana, Long>, UpbitCommonJpaInterface {
        }