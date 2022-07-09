package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwBchRepository extends JpaRepository<BithumbTickKrwBch, Long>, BithumbTickCommonJpaInterface {
}
