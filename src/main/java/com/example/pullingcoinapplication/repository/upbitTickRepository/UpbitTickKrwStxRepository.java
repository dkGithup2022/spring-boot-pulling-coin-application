package com.example.pullingcoinapplication.repository.upbitTickRepository;

import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwStx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwStxRepository extends JpaRepository<UpbitTickKrwStx,Long>, UpbitCommonJpaInterface {
}
