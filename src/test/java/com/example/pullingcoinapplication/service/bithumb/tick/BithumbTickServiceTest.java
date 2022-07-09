package com.example.pullingcoinapplication.service.bithumb.tick;

import com.example.pullingcoinapplication.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.example.pullingcoinapplication.entity.bithumb.tick.BithumbTick;
import com.example.pullingcoinapplication.entity.bithumb.tick.BithumbTickFactory;
import com.example.pullingcoinapplication.util.CodeUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class BithumbTickServiceTest {

    @Autowired
    private BithumbTickService bithumbTickService;

    @Test
    void empty() {

    }

    @Test
    void save() {
        BithumbCoinCode[] codes = BithumbCoinCode.values();
        for (BithumbCoinCode code : codes) {
            BithumbTick t = new BithumbTick();
            t.setCode(code.name());
            System.out.println(bithumbTickService.save(BithumbTickFactory.of(t)));
        }
    }

    @Test
    void saveAndFind() {
        BithumbCoinCode[] codes = BithumbCoinCode.values();
        ArrayList<BithumbTick> ts = new ArrayList<BithumbTick>();

        for (BithumbCoinCode code : codes) {
            BithumbTick t = new BithumbTick();
            t.setCode(code.name());
            ts.add(bithumbTickService.save(BithumbTickFactory.of(t)));
        }

        int result = 0;
        for (BithumbTick t : ts) {
            if (bithumbTickService.findOneByCodeAndId
                            (CodeUtil.getBithumbCoinCodeFromString(t.getCode()), t.getId()) == null)
                continue;
            result++;
        }

        System.out.println("result ");
        assertEquals(result, BithumbCoinCode.values().length);
    }
}