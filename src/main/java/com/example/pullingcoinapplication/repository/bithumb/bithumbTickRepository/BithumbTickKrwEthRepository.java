package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwEthRepository extends JpaRepository<BithumbTickKrwEth, Long>, BithumbTickCommonJpaInterface {
}
