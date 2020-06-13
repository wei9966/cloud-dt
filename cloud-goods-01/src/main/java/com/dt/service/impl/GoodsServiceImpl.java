package com.dt.service.impl;

import com.dt.pojo.Goods;
import com.dt.service.GoodsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Create By WeiBin on 2020/6/1 12:14
 *
 * @author WB
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private static final Map<Integer, Goods> GOODS_MAP = new HashMap<>();

    @Value("${server.port}")
    String port;

    static {
        GOODS_MAP.put(1, new Goods(1, "苹果11", 999D));
        GOODS_MAP.put(2, new Goods(2, "苹果12", 888D));
        GOODS_MAP.put(3, new Goods(3, "苹果13", 777D));
    }

    @Override
    public Goods getGoodsById(int id) {
        Goods goods = GOODS_MAP.get(id);
        goods.setPort(port);
        return goods;
    }
}
