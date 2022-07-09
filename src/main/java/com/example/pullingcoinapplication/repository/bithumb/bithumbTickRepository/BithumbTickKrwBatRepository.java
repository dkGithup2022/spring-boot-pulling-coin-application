package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwBatRepository extends JpaRepository<BithumbTickKrwBat, Long>, BithumbTickCommonJpaInterface {
}
