package com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAdaRepository extends JpaRepository<UpbitCandleKrwAda, Long>, UpbitCandleCommonJpaInterface {
}
