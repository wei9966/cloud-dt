package com.dt.service;

import com.dt.pojo.Goods;
import com.dt.pojo.GoodsOrder;

/**
 * Create By WeiBin on 2020/6/2 15:50
 * @author WB
 */
public interface OrderService {
    /**
     * 保存商品
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 订单商品
     */
    GoodsOrder saveGoods(int userId,int goodsId);
}
