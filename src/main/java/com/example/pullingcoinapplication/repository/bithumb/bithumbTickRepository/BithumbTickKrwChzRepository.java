package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwChzRepository extends JpaRepository<BithumbTickKrwChz, Long>, BithumbTickCommonJpaInterface {
}
