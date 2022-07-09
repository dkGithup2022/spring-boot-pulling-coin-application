package com.example.pullingcoinapplication.service.bithumb.tick;

import com.example.pullingcoinapplication.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.example.pullingcoinapplication.entity.bithumb.tick.BithumbTick;
import com.example.pullingcoinapplication.exception.CoinDataException;
import com.example.pullingcoinapplication.exception.CoinDataExceptionCode;
import com.example.pullingcoinapplication.repository.bithumb.bithumbTickRepository.*;
import com.example.pullingcoinapplication.util.CodeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BithumbTickService {

    private final BithumbTickRespositoryPicker bithumbTickRespositoryPicker;

    public BithumbTick save(BithumbTick bithumbTick) {
        BithumbTickCommonJpaInterface repo = bithumbTickRespositoryPicker.pickRepository(bithumbTick.getCode());
        return repo.save(bithumbTick);
    }

    public BithumbTick findOneByCodeAndId(BithumbCoinCode code, Long id) {
        BithumbTickCommonJpaInterface repo = bithumbTickRespositoryPicker.pickRepository(code);
        return repo.findOneById(id);
    }
}


@Component
@RequiredArgsConstructor
@Slf4j
class BithumbTickRespositoryPicker {

    private final CodeUtil codeUtil;
    // TODO : 뭔가 찜찜한 코드

    private final BithumbTickKrwDotRepository bithumbTickKrwDotRepository;
    private final BithumbTickKrwSolRepository bithumbTickKrwSolRepository;
    private final BithumbTickKrwAdaRepository bithumbTickKrwAdaRepository;
    private final BithumbTickKrwAtomRepository bithumbTickKrwAtomRepository;
    private final BithumbTickKrwAvaxRepository bithumbTickKrwAvaxRepository;
    private final BithumbTickKrwAxsRepository bithumbTickKrwAxsRepository;
    private final BithumbTickKrwBatRepository bithumbTickKrwBatRepository;
    private final BithumbTickKrwBchRepository bithumbTickKrwBchRepository;
    private final BithumbTickKrwBtcRepository bithumbTickKrwBtcRepository;
    private final BithumbTickKrwBtgRepository bithumbTickKrwBtgRepository;
    private final BithumbTickKrwChzRepository bithumbTickKrwChzRepository;
    private final BithumbTickKrwDogeRepository bithumbTickKrwDogeRepository;
    private final BithumbTickKrwEnjRepository bithumbTickKrwEnjRepository;
    private final BithumbTickKrwEthRepository bithumbTickKrwEthRepository;
    private final BithumbTickKrwEtcRepository bithumbTickKrwEtcRepository;
    private final BithumbTickKrwManaRepository bithumbTickKrwManaRepository;
    private final BithumbTickKrwMaticRepository bithumbTickKrwMaticRepository;
    private final BithumbTickKrwPlaRepository bithumbTickKrwPlaRepository;
    private final BithumbTickKrwSandRepository bithumbTickKrwSandRepository;
    private final BithumbTickKrwSrmRepository bithumbTickKrwSrmRepository;
    private final BithumbTickKrwXrpRepository bithumbTickKrwXrpRepository;


    public BithumbTickCommonJpaInterface pickRepository(BithumbTick bithumbTick) {
        return getRepositoryFromCode(BithumbCoinCode.fromString(bithumbTick.getCode()));
    }

    public BithumbTickCommonJpaInterface pickRepository(BithumbCoinCode code) {
        return getRepositoryFromCode(code);
    }

    public BithumbTickCommonJpaInterface pickRepository(String strCode) {
        return getRepositoryFromCode(BithumbCoinCode.fromString(strCode));
    }


    private BithumbTickCommonJpaInterface getRepositoryFromCode(BithumbCoinCode code) {
        switch (code) {
            case KRW_ADA:
                return bithumbTickKrwAdaRepository;
            case KRW_ATOM:
                return bithumbTickKrwAtomRepository;
            case KRW_AVAX:
                return bithumbTickKrwAvaxRepository;
            case KRW_AXS:
                return bithumbTickKrwAxsRepository;
            case KRW_BAT:
                return bithumbTickKrwBatRepository;
            case KRW_BCH:
                return bithumbTickKrwBchRepository;
            case KRW_BTC:
                return bithumbTickKrwBtcRepository;
            case KRW_BTG:
                return bithumbTickKrwBtgRepository;
            case KRW_CHZ:
                return bithumbTickKrwChzRepository;
            case KRW_DOGE:
                return bithumbTickKrwDogeRepository;
            case KRW_DOT:
                return bithumbTickKrwDotRepository;
            case KRW_ENJ:
                return bithumbTickKrwEnjRepository;
            case KRW_ETH:
                return bithumbTickKrwEthRepository;
            case KRW_ETC:
                return bithumbTickKrwEtcRepository;
            case KRW_MANA:
                return bithumbTickKrwManaRepository;
            case KRW_MATIC:
                return bithumbTickKrwMaticRepository;
            case KRW_PLA:
                return bithumbTickKrwPlaRepository;
            case KRW_SAND:
                return bithumbTickKrwSandRepository;
            case KRW_SRM:
                return bithumbTickKrwSrmRepository;
            case KRW_SOL:
                return bithumbTickKrwSolRepository;
            case KRW_XRP:
                return bithumbTickKrwXrpRepository;
            default:
                log.error("BithumbRespositoryPicker.getRepositoryFromCode , when code :  {}", code);
                throw new CoinDataException(CoinDataExceptionCode.INVALID_COIN_CODE);
        }
    }
}