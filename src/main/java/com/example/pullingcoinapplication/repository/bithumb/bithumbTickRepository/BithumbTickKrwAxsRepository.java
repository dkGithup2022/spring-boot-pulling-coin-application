package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwAxsRepository extends JpaRepository<BithumbTickKrwAxs, Long>, BithumbTickCommonJpaInterface {
}
