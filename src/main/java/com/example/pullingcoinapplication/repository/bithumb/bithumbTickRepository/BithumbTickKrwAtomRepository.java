package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;

import com.example.pullingcoinapplication.entity.bithumb.tick.coins.BithumbTickKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwAtomRepository extends JpaRepository<BithumbTickKrwAtom, Long>, BithumbTickCommonJpaInterface {
}
