package com.example.pullingcoinapplication.repository.upbitCandleRepository;

import com.example.pullingcoinapplication.entity.upbit.candle.coin.UpbitCandleKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwXrpRepository extends JpaRepository<UpbitCandleKrwXrp, Long>, UpbitCandleCommonJpaInterface {
}
