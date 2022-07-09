package com.example.pullingcoinapplication.service.upbit.orderbook;


import com.example.pullingcoinapplication.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;
import com.example.pullingcoinapplication.exception.CoinDataException;
import com.example.pullingcoinapplication.exception.CoinDataExceptionCode;
import com.example.pullingcoinapplication.repository.upbit.upbitOrderBookRepository.*;
import com.example.pullingcoinapplication.util.CodeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UpbitOrderBookService {
    private final UpbitOrderbookRepositoryPicker upbitOrderbookRepositoryPicker;
    public UpbitOrderbook save(UpbitOrderbook upbitOrderbook) {
        UpbitOrderbookCommonRepository repository = upbitOrderbookRepositoryPicker.getRepository(upbitOrderbook);
        return repository.save(upbitOrderbook);
    }
    public UpbitOrderbook findByCodeAndTimestamp(UpbitCoinCode code, Long timestamp) {
        UpbitOrderbookCommonRepository repository = upbitOrderbookRepositoryPicker.getRepository(code);
        UpbitOrderbook orderbook = repository.findOneByTimestamp(timestamp);
        return orderbook;
    }
}


@Component
@RequiredArgsConstructor
@Slf4j
class UpbitOrderbookRepositoryPicker {

    private final UpbitOrderbookKrwAdaRepository upbitOrderbookKrwAdaRepository;
    private final UpbitOrderbookKrwAtomRepository upbitOrderbookKrwAtomRepository;
    private final UpbitOrderbookKrwAvaxRepository upbitOrderbookKrwAvaxRepository;
    private final UpbitOrderbookKrwAxsRepository upbitOrderbookKrwAxsRepository;
    private final UpbitOrderbookKrwBatRepository upbitOrderbookKrwBatRepository;
    private final UpbitOrderbookKrwBchRepository upbitOrderbookKrwBchRepository;
    private final UpbitOrderbookKrwBtcRepository upbitOrderbookKrwBtcRepository;
    private final UpbitOrderbookKrwBtgRepository upbitOrderbookKrwBtgRepository;
    private final UpbitOrderbookKrwChzRepository upbitOrderbookKrwChzRepository;
    private final UpbitOrderbookKrwDogeRepository upbitOrderbookKrwDogeRepository;
    private final UpbitOrderbookKrwDotRepository upbitOrderbookKrwDotRepository;
    private final UpbitOrderbookKrwEnjRepository upbitOrderbookKrwEnjRepository;
    private final UpbitOrderbookKrwEtcRepository upbitOrderbookKrwEtcRepository;
    private final UpbitOrderbookKrwEthRepository upbitOrderbookKrwEthRepository;
    private final UpbitOrderbookKrwFlowRepository upbitOrderbookKrwFlowRepository;
    private final UpbitOrderbookKrwManaRepository upbitOrderbookKrwManaRepository;
    private final UpbitOrderbookKrwMaticRepository upbitOrderbookKrwMaticRepository;
    private final UpbitOrderbookKrwPlaRepository upbitOrderbookKrwPlaRepository;
    private final UpbitOrderbookKrwSandRepository upbitOrderbookKrwSandRepository;
    private final UpbitOrderbookKrwSolRepository upbitOrderbookKrwSolRepository;
    private final UpbitOrderbookKrwSrmRepository upbitOrderbookKrwSrmRepository;
    private final UpbitOrderbookKrwStxRepository upbitOrderbookKrwStxRepository;
    private final UpbitOrderbookKrwXrpRepository upbitOrderbookKrwXrpRepository;

    UpbitOrderbookCommonRepository getRepository(UpbitCoinCode code) {
        return getRepositoryFromCode(code);
    }

    UpbitOrderbookCommonRepository getRepository(UpbitOrderbook orderbook) {
        return getRepository(CodeUtil.getCoinCodeFromString(orderbook.getCode()));
    }

    UpbitOrderbookCommonRepository getRepository(String code) {
        return getRepository(CodeUtil.getCoinCodeFromString(code));
    }


    private UpbitOrderbookCommonRepository getRepositoryFromCode(UpbitCoinCode code) {
        switch (code) {
            case KRW_ADA:
                return upbitOrderbookKrwAdaRepository;
            case KRW_ATOM:
                return upbitOrderbookKrwAtomRepository;
            case KRW_AVAX:
                return upbitOrderbookKrwAvaxRepository;
            case KRW_AXS:
                return upbitOrderbookKrwAxsRepository;
            case KRW_BAT:
                return upbitOrderbookKrwBatRepository;
            case KRW_BCH:
                return upbitOrderbookKrwBchRepository;
            case KRW_BTC:
                return upbitOrderbookKrwBtcRepository;
            case KRW_BTG:
                return upbitOrderbookKrwBtgRepository;
            case KRW_CHZ:
                return upbitOrderbookKrwChzRepository;
            case KRW_DOGE:
                return upbitOrderbookKrwDogeRepository;
            case KRW_DOT:
                return upbitOrderbookKrwDotRepository;
            case KRW_ENJ:
                return upbitOrderbookKrwEnjRepository;
            case KRW_ETH:
                return upbitOrderbookKrwEthRepository;
            case KRW_ETC:
                return upbitOrderbookKrwEtcRepository;
            case KRW_FLOW:
                return upbitOrderbookKrwFlowRepository;
            case KRW_MANA:
                return upbitOrderbookKrwManaRepository;
            case KRW_MATIC:
                return upbitOrderbookKrwMaticRepository;
            case KRW_PLA:
                return upbitOrderbookKrwPlaRepository;
            case KRW_SAND:
                return upbitOrderbookKrwSandRepository;
            case KRW_SRM:
                return upbitOrderbookKrwSrmRepository;
            case KRW_STX:
                return upbitOrderbookKrwStxRepository;
            case KRW_SOL:
                return upbitOrderbookKrwSolRepository;
            case KRW_XRP:
                return upbitOrderbookKrwXrpRepository;

            default:
                log.error("UpbitRespositoryPicker.getRepositoryFromCode , when code :  {}", code);
                throw new CoinDataException(CoinDataExceptionCode.INVALID_COIN_CODE);
        }
    }

}