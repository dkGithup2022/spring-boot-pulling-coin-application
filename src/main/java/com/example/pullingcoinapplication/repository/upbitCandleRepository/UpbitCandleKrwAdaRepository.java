package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAdaRepository extends JpaRepository<UpbitCandleKrwAda, Long>, UpbitCandleCommonJpaInterface {
}
