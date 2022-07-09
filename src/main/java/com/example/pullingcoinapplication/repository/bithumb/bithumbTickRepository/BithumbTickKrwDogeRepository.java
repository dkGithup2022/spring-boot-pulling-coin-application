package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwDogeRepository extends JpaRepository<BithumbTickKrwDoge, Long>, BithumbTickCommonJpaInterface {
}
