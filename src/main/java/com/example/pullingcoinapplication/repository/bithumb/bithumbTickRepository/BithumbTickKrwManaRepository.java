package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwManaRepository extends JpaRepository<BithumbTickKrwMana, Long>, BithumbTickCommonJpaInterface {
}
