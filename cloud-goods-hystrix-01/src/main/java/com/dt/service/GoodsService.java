package com.dt.service;

import com.dt.pojo.Goods;

/**
 * Create By WeiBin on 2020/6/1 12:14
 *
 * @author WB
 */
public interface GoodsService {
    /**
     * 查询商品
     * @param id 商品id
     * @return 返回商品
     */
    public Goods getGoodsById(int id);
}
