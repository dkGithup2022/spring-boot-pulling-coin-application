package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwPlaRepository extends JpaRepository<BithumbTickKrwPla, Long>, BithumbTickCommonJpaInterface {
}
