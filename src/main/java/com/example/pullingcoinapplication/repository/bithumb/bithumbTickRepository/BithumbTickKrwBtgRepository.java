package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwBtgRepository extends JpaRepository<BithumbTickKrwBtg, Long>, BithumbTickCommonJpaInterface {
}
