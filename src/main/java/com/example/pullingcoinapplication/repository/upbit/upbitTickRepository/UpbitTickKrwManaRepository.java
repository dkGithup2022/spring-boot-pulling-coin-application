package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwManaRepository extends JpaRepository<UpbitTickKrwMana, Long>, UpbitCommonJpaInterface {
        }