package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;


import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAtomRepository extends JpaRepository<UpbitCandleKrwAtom, Long>, UpbitCandleCommonJpaInterface {
}
