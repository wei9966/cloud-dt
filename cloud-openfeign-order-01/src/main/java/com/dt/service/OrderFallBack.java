package com.dt.service;

import com.dt.pojo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Create By WeiBin on 2020/6/4 18:35
 * @author WB
 */
@Component
@Slf4j
public class OrderFallBack implements OrderService {
    @Override
    public Goods saveGoods(int userId, int goodsId) {
        log.error("发生服务熔断,商品查询失败，用户id是"+userId+"想要查询的订单编号是"+goodsId);
        throw new RuntimeException("商品服务调用失败");
    }
}
