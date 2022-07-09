package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwSolRepository extends JpaRepository<BithumbTickKrwSol, Long>, BithumbTickCommonJpaInterface {
}
