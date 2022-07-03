package com.example.pullingcoinapplication.repository.upbitTickRepository;

import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwXrpRepository extends JpaRepository<UpbitTickKrwXrp,Long>, UpbitCommonJpaInterface {
}
