package com.example.pullingcoinapplication.service.tick;


import com.example.pullingcoinapplication.constants.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTick;
import com.example.pullingcoinapplication.entity.upbit.upbitTick.UpbitTickPk;
import com.example.pullingcoinapplication.exception.CoinDataException;
import com.example.pullingcoinapplication.exception.CoinDataExceptionCode;
import com.example.pullingcoinapplication.repository.upbitTickRepository.*;
import com.example.pullingcoinapplication.util.UpbitCodeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UpbitTickService {

    private final UpbitRespositoryPicker upbitRespositoryPicker;

    public void save(UpbitTick upbitTick) {
        UpbitCommonJpaInterface repository = upbitRespositoryPicker.pickRepository(upbitTick);
        repository.save(upbitTick);
    }


    public UpbitTick findByPk(UpbitTickPk upbitTickPk) {
        UpbitCommonJpaInterface repository = upbitRespositoryPicker.pickRepository(upbitTickPk.getCode());
        return repository.findBySequentialId(upbitTickPk.getSequentialId());
    }

    @Transactional
    public void saveWhenNotExist(UpbitTick upbitTick){
        UpbitCommonJpaInterface repository = upbitRespositoryPicker.pickRepository(upbitTick.getCode());
        if(repository.findBySequentialId(upbitTick.getSequentialId()) != null){
            return;
        }
        System.out.println("save unfound tick : " + upbitTick);
        this.save(upbitTick);
    }

    public List<UpbitTick> findByTimestampBetweenOrderByTimestampDesc(UpbitCoinCode code,Long old, Long now){
        UpbitCommonJpaInterface repository = upbitRespositoryPicker.pickRepository(code);
        return repository.findByTimestampBetweenOrderByTimestampDesc(old,now);
    }
}


@Component
@RequiredArgsConstructor
@Slf4j
class UpbitRespositoryPicker {

    private final UpbitCodeUtil upbitCodeUtil;
    // TODO : 뭔가 찜찜한 코드

    private final UpbitTickKrwDotRepository upbitTickKrwDotRepository;
    private final UpbitTickKrwSolRepository upbitTickKrwSolRepository;
    private final UpbitTickKrwStxRepository upbitTickKrwStxRepository;
    private final UpbitTickKrwAdaRepository upbitTickKrwAdaRepository;
    private final UpbitTickKrwAtomRepository upbitTickKrwAtomRepository;
    private final UpbitTickKrwAvaxRepository upbitTickKrwAvaxRepository;
    private final UpbitTickKrwAxsRepository upbitTickKrwAxsRepository;
    private final UpbitTickKrwBatRepository upbitTickKrwBatRepository;
    private final UpbitTickKrwBchRepository upbitTickKrwBchRepository;
    private final UpbitTickKrwBtcRepository upbitTickKrwBtcRepository;
    private final UpbitTickKrwBtgRepository upbitTickKrwBtgRepository;
    private final UpbitTickKrwChzRepository upbitTickKrwChzRepository;
    private final UpbitTickKrwDogeRepository upbitTickKrwDogeRepository;
    private final UpbitTickKrwEnjRepository upbitTickKrwEnjRepository;
    private final UpbitTickKrwEthRepository upbitTickKrwEthRepository;
    private final UpbitTickKewEtcRepository upbitTickKrwEtcRepository;
    private final UpbitTickKrwFlowRepository upbitTickKrwFlowRepository;
    private final UpbitTickKrwManaRepository upbitTickKrwManaRepository;
    private final UpbitTickKrwMaticRepository upbitTickKrwMaticRepository;
    private final UpbitTickKrwPlaRepository upbitTickKrwPlaRepository;
    private final UpbitTickKrwSandRepository upbitTickKrwSandRepository;
    private final UpbitTickKrwSrmRepository upbitTickKrwSrmRepository;
    private final UpbitTickKrwXrpRepository upbitTickKrwXrpRepository;



    public UpbitCommonJpaInterface pickRepository(UpbitTick upbitTick) {
        return getRepositoryFromCode(upbitCodeUtil.getCoinCodeFromString(upbitTick.getCode()));
    }

    public UpbitCommonJpaInterface pickRepository(UpbitCoinCode code) {
        return getRepositoryFromCode(code);
    }

    public UpbitCommonJpaInterface pickRepository(String strCode) {
        return getRepositoryFromCode(upbitCodeUtil.getCoinCodeFromString(strCode));
    }



    private UpbitCommonJpaInterface getRepositoryFromCode(UpbitCoinCode code) {
        switch (code) {
            case KRW_ADA:
                return upbitTickKrwAdaRepository;
            case KRW_ATOM:
                return upbitTickKrwAtomRepository;
            case KRW_AVAX:
                return upbitTickKrwAvaxRepository;
            case KRW_AXS:
                return upbitTickKrwAxsRepository;
            case KRW_BAT:
                return upbitTickKrwBatRepository;
            case KRW_BCH:
                return upbitTickKrwBchRepository;
            case KRW_BTC:
                return upbitTickKrwBtcRepository;
            case KRW_BTG:
                return upbitTickKrwBtgRepository;
            case KRW_CHZ:
                return upbitTickKrwChzRepository;
            case KRW_DOGE:
                return upbitTickKrwDogeRepository;
            case KRW_DOT:
                return upbitTickKrwDotRepository;
            case KRW_ENJ:
                return upbitTickKrwEnjRepository;
            case KRW_ETH:
                return upbitTickKrwEthRepository;
            case KRW_ETC:
                return upbitTickKrwEtcRepository;
            case KRW_FLOW:
                return upbitTickKrwFlowRepository;
            case KRW_MANA:
                return upbitTickKrwManaRepository;
            case KRW_MATIC:
                return upbitTickKrwMaticRepository;
            case KRW_PLA:
                return upbitTickKrwPlaRepository;
            case KRW_SAND:
                return upbitTickKrwSandRepository;
            case KRW_SRM:
                return upbitTickKrwSrmRepository;
            case KRW_STX:
                return upbitTickKrwStxRepository;
            case KRW_SOL:
                return upbitTickKrwSolRepository;
            case KRW_XRP:
                return upbitTickKrwXrpRepository;

            default:
                log.error("UpbitRespositoryPicker.getRepositoryFromCode , when code :  {}" , code);
                throw new CoinDataException(CoinDataExceptionCode.INVALID_COIN_CODE);
        }
    }

}