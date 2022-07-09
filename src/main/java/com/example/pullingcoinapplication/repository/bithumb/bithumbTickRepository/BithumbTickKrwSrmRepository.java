package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwSrmRepository extends JpaRepository<BithumbTickKrwSrm, Long>, BithumbTickCommonJpaInterface {
}
