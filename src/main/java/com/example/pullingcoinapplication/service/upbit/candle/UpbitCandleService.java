package com.example.pullingcoinapplication.service.upbit.candle;

import com.example.pullingcoinapplication.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.entity.upbit.candle.UpbitCandle;
import com.example.pullingcoinapplication.repository.upbit.upbitCandleRepository.*;
import com.example.pullingcoinapplication.util.CodeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpbitCandleService {
    private final CandleRepositoryPicker candleRepositoryPicker;

    public UpbitCandle save(UpbitCandle candle) {
        UpbitCandleCommonJpaInterface repo = candleRepositoryPicker.pickRepository(candle);
        return repo.save(candle);
    }

    public UpbitCandle findOneByMarketAndTimestamp(UpbitCoinCode code, Long timestamp) {
        UpbitCandleCommonJpaInterface repo = candleRepositoryPicker.pickRepository(code);
        return repo.findOneByTimestamp(timestamp);
    }

    public UpbitCandle safeSave(UpbitCandle candle) {
        if (findOneByMarketAndTimestamp(CodeUtil.getCoinCodeFromString(candle.getMarket()), candle.getTimestamp()) == null) {
            return save(candle);
        } else {
            return null;
        }
    }
}


@Component
@RequiredArgsConstructor
class CandleRepositoryPicker {
    private final UpbitCandleKrwBtcRepository upbitCandleKrwBtcRepository;
    private final UpbitCandleKrwAdaRepository upbitCandleKrwAdaRepository;
    private final UpbitCandleKrwAtomRepository upbitCandleKrwAtomRepository;
    private final UpbitCandleKrwAvaxRepository upbitCandleKrwAvaxRepository;
    private final UpbitCandleKrwAxsRepository upbitCandleKrwAxsRepository;
    private final UpbitCandleKrwBatRepository upbitCandleKrwBatRepository;
    private final UpbitCandleKrwBchRepository upbitCandleKrwBchRepository;
    private final UpbitCandleKrwBtgRepository upbitCandleKrwBtgRepository;
    private final UpbitCandleKrwChzRepository upbitCandleKrwChzRepository;
    private final UpbitCandleKrwDogeRepository upbitCandleKrwDogeRepository;
    private final UpbitCandleKrwDotRepository upbitCandleKrwDotRepository;
    private final UpbitCandleKrwEnjRepository upbitCandleKrwEnjRepository;
    private final UpbitCandleKrwEtcRepository upbitCandleKrwEtcRepository;
    private final UpbitCandleKrwEthRepository upbitCandleKrwEthRepository;
    private final UpbitCandleKrwFlowRepository upbitCandleKrwFlowRepository;
    private final UpbitCandleKrwManaRepository upbitCandleKrwManaRepository;
    private final UpbitCandleKrwMaticRepository upbitCandleKrwMaticRepository;
    private final UpbitCandleKrwPlaRepository upbitCandleKrwPlaRepository;
    private final UpbitCandleKrwSandRepository upbitCandleKrwSandRepository;
    private final UpbitCandleKrwSolRepository upbitCandleKrwSolRepository;
    private final UpbitCandleKrwSrmRepository upbitCandleKrwSrmRepository;
    private final UpbitCandleKrwStxRepository upbitCandleKrwStxRepository;
    private final UpbitCandleKrwXrpRepository upbitCandleKrwXrpRepository;

    public UpbitCandleCommonJpaInterface pickRepository(UpbitCandle candle) {
        return getRepositoryFromCode(CodeUtil.getCoinCodeFromString(candle.getMarket()));
    }

    public UpbitCandleCommonJpaInterface pickRepository(UpbitCoinCode code) {
        return getRepositoryFromCode(code);
    }

    public UpbitCandleCommonJpaInterface pickRepository(String strCode) {
        return getRepositoryFromCode(CodeUtil.getCoinCodeFromString(strCode));
    }

    private UpbitCandleCommonJpaInterface getRepositoryFromCode(UpbitCoinCode code) {
        switch (code) {
            case KRW_BTC:
                return upbitCandleKrwBtcRepository;
            case KRW_ADA:
                return upbitCandleKrwAdaRepository;
            case KRW_ATOM:
                return upbitCandleKrwAtomRepository;
            case KRW_AVAX:
                return upbitCandleKrwAvaxRepository;
            case KRW_AXS:
                return upbitCandleKrwAxsRepository;
            case KRW_BAT:
                return upbitCandleKrwBatRepository;
            case KRW_BCH:
                return upbitCandleKrwBchRepository;
            case KRW_BTG:
                return upbitCandleKrwBtgRepository;
            case KRW_CHZ:
                return upbitCandleKrwChzRepository;
            case KRW_DOGE:
                return upbitCandleKrwDogeRepository;
            case KRW_DOT:
                return upbitCandleKrwDotRepository;
            case KRW_ENJ:
                return upbitCandleKrwEnjRepository;
            case KRW_ETC:
                return upbitCandleKrwEtcRepository;
            case KRW_ETH:
                return upbitCandleKrwEthRepository;
            case KRW_FLOW:
                return upbitCandleKrwFlowRepository;
            case KRW_MANA:
                return upbitCandleKrwManaRepository;
            case KRW_MATIC:
                return upbitCandleKrwMaticRepository;
            case KRW_PLA:
                return upbitCandleKrwPlaRepository;
            case KRW_SAND:
                return upbitCandleKrwSandRepository;
            case KRW_SOL:
                return upbitCandleKrwSolRepository;
            case KRW_SRM:
                return upbitCandleKrwSrmRepository;
            case KRW_STX:
                return upbitCandleKrwStxRepository;
            case KRW_XRP:
                return upbitCandleKrwXrpRepository;
            default:
                throw new IllegalStateException("illigal market" + code.toString());
        }
    }


}
