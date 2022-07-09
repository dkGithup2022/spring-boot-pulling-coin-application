package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwXrpRepository extends JpaRepository<BithumbTickKrwXrp, Long>, BithumbTickCommonJpaInterface {
}
