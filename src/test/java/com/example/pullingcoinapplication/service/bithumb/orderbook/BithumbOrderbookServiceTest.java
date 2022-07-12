package com.example.pullingcoinapplication.service.bithumb.orderbook;

import com.example.pullingcoinapplication.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.BithumbOrderbook;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.BithumbOrderbookFactory;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.BithumbOrderbookUnit;
import com.example.pullingcoinapplication.entity.upbit.orderbook.UpbitOrderbook;
import com.example.pullingcoinapplication.entity.upbit.tick.UpbitTick;
import com.example.pullingcoinapplication.service.bithumb.tick.BithumbTickService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BithumbOrderbookServiceTest {

    @Autowired
    private BithumbOrderbookService bithumbOrderbookService;

    @Test
    public void empty(){}

    @Test
    public void save() {

        ArrayList<BithumbOrderbookUnit> list = new ArrayList<>();
        BithumbOrderbookUnit unit1 = new BithumbOrderbookUnit("ask", (double)  100,(double) 100,(double) 10000);
        BithumbOrderbookUnit unit2 = new BithumbOrderbookUnit("ask",(double) 200,(double) 300,(double) 60000);

        list.add(unit1);
        list.add(unit2);

        BithumbOrderbook bithumbOrderbook = new BithumbOrderbook(100L,"BTC_KRW",list);
        BithumbOrderbook bob =  bithumbOrderbookService.save(BithumbOrderbookFactory.of(bithumbOrderbook));

        assertEquals(bob,bithumbOrderbook);
    }

    @Test
    public void findOneByCodeAndDatetime(){
        BithumbOrderbook bithumbOrderbook = new BithumbOrderbook(100L,"BTC_KRW",null);
        BithumbOrderbook bob =  bithumbOrderbookService.save(BithumbOrderbookFactory.of(bithumbOrderbook));

        BithumbOrderbook found = bithumbOrderbookService.findOneByCodeAndDatetime(BithumbCoinCode.KRW_BTC,100L);
        assertEquals(found,bob);
    }
}