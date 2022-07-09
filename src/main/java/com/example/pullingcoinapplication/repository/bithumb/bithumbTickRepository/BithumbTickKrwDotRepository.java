package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwDotRepository extends JpaRepository<BithumbTickKrwDot, Long>, BithumbTickCommonJpaInterface {
}
