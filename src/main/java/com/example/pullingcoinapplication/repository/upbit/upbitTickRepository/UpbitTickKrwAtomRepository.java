package com.example.pullingcoinapplication.repository.upbit.upbitTickRepository;


import com.example.pullingcoinapplication.entity.upbit.tick.coins.UpbitTickKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwAtomRepository extends JpaRepository<UpbitTickKrwAtom, Long>, UpbitCommonJpaInterface {
}

