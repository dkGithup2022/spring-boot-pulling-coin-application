package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwAvaxRepository extends JpaRepository<BithumbTickKrwAvax, Long>, BithumbTickCommonJpaInterface {
}
