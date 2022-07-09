package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwSandRepository extends JpaRepository<BithumbTickKrwSand, Long>, BithumbTickCommonJpaInterface {
}
