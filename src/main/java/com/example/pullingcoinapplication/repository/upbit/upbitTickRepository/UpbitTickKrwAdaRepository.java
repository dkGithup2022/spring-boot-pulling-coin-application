package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwAdaRepository extends JpaRepository<UpbitTickKrwAda, Long>, UpbitCommonJpaInterface {
}

