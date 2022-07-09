package com.example.pullingcoinapplication.entity.bithumb.candle;

import com.example.pullingcoinapplication.constants.coinCode.bithumbCoinCode.BithumbCoinCode;

import com.example.pullingcoinapplication.entity.bithumb.candle.coins.*;
import com.example.pullingcoinapplication.exception.CoinDataException;
import com.example.pullingcoinapplication.exception.CoinDataExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BithumbCandleFactory {
    private final static ModelMapper modelMapper = new ModelMapper();
    public static BithumbCandle of(BithumbCandle bithumbCandle){
        BithumbCoinCode bithumbCoinCode = BithumbCoinCode.fromString(bithumbCandle.getCode());
        switch (bithumbCoinCode){
            case KRW_ADA:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwAda.class);
            case KRW_ATOM:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwAtom.class);
            case KRW_AVAX:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwAvax.class);
            case KRW_AXS:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwAxs.class);
            case KRW_BAT:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwBat.class);
            case KRW_BCH:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwBch.class);
            case KRW_BTC:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwBtc.class);
            case KRW_BTG:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwBtg.class);
            case KRW_CHZ:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwChz.class);
            case KRW_DOGE:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwDoge.class);
            case KRW_DOT:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwDot.class);
            case KRW_ENJ:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwEnj.class);
            case KRW_ETC:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwEtc.class);
            case KRW_ETH:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwEth.class);
            case KRW_MANA:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwMana.class);
            case KRW_MATIC:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwMatic.class);
            case KRW_PLA:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwPla.class);
            case KRW_SAND:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwSand.class);
            case KRW_SRM:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwSrm.class);
            case KRW_SOL:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwSol.class);
            case KRW_XRP:
                return modelMapper.map(bithumbCandle, BithumbCandleKrwXrp.class);

            default:
                log.error("BithumbCandleTickFactory.of | when coin :  {}" ,bithumbCandle.getCode());
                throw new CoinDataException(CoinDataExceptionCode.INVALID_COIN_CODE);
        }
    }
}
