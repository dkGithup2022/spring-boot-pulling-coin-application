package com.example.pullingcoinapplication.entity.bithumb.orderbook.coins;


import com.example.pullingcoinapplication.entity.bithumb.orderbook.BithumbOrderbook;
import com.example.pullingcoinapplication.entity.bithumb.orderbook.BithumbOrderbookUnit;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "bithumb_orderbook_krw_srm",indexes = {
        @Index(name = "bithumb_orderbook_krw_srm_index",  columnList="datetime",unique = false)
})
public class BithumbOrderbookKrwSrm extends BithumbOrderbook {
}
