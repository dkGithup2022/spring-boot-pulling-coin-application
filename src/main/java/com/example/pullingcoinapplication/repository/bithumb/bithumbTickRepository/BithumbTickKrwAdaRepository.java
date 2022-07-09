package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwAdaRepository extends JpaRepository<BithumbTickKrwAda, Long>, BithumbTickCommonJpaInterface {
}
