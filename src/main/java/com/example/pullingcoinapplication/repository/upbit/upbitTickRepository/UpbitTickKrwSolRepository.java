package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;

import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwSolRepository extends JpaRepository<UpbitTickKrwSol,Long> , UpbitCommonJpaInterface{
}
