package com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository;


import com.example.pullingcoinapplication.entity.bithumb.tick.BithumbTick;

public interface BithumbTickCommonJpaInterface {

    BithumbTick save(BithumbTick tick);
    BithumbTick findOneById(Long id);
}
