package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwEnjRepository extends JpaRepository<BithumbTickKrwEnj, Long>, BithumbTickCommonJpaInterface {
}
