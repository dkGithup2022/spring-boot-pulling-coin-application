package com.example.pullingcoinapplication.repository.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwAtom;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.coins.UpbitTickKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwAtomRepository extends JpaRepository<UpbitTickKrwAtom, Long>, UpbitCommonJpaInterface {
}

