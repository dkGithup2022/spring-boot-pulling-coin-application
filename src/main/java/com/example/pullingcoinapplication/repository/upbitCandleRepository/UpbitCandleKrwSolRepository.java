package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwSolRepository extends JpaRepository<UpbitCandleKrwSol, Long>, UpbitCandleCommonJpaInterface {
}
