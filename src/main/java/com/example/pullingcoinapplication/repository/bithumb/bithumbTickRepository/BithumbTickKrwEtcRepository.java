package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwEtcRepository extends JpaRepository<BithumbTickKrwEtc, Long>, BithumbTickCommonJpaInterface {
}
