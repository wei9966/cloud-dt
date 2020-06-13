package com.dt.service;

import com.dt.pojo.Goods;
import com.dt.pojo.GoodsOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By WeiBin on 2020/6/2 15:50
 * @author WB
 */
@Component
@FeignClient(name = "CLOUD-GOODS-01",fallback = OrderFallBack.class)
public interface OrderService {
    /**
     * 保存商品
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 订单商品
     */
    @RequestMapping("/goods/getGoods/{id}")
    Goods saveGoods(int userId, @PathVariable("id") int goodsId);
}
