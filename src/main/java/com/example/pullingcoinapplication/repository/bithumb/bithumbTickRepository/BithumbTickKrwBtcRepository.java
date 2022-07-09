package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwBtcRepository extends JpaRepository<BithumbTickKrwBtc, Long>, BithumbTickCommonJpaInterface {
}
