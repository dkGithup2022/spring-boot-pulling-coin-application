package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwMaticRepository extends JpaRepository<BithumbTickKrwMatic, Long>, BithumbTickCommonJpaInterface {
}
