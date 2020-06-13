package com.dt.service.impl;

import com.dt.pojo.Goods;
import com.dt.pojo.GoodsOrder;
import com.dt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Create By WeiBin on 2020/6/2 15:50
 *
 * @author WB
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RestTemplate restTemplate;
    private static final String SERVICE_URI = "http://CLOUD-GOODS-01";

    @Override
    public GoodsOrder saveGoods(int userId, int goodsId) {
        Goods goods = restTemplate.getForObject(SERVICE_URI + "/goods/getGoods/" + goodsId, Goods.class);
        System.out.println("------>跨域请求后获取的数据" + goods);
        GoodsOrder goodsOrder = new GoodsOrder();
        goodsOrder.setOrderId(goodsId);
        goodsOrder.setNum(10);
        goodsOrder.setUserId(userId);
        goodsOrder.setGoods(goods);
        return goodsOrder;
    }
}
