package com.dt.controller;

import com.dt.pojo.Goods;
import com.dt.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By WeiBin on 2020/6/1 12:13
 *
 * @author WB
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/getGoods/{id}")
    public Goods getGoods(@PathVariable("id") Integer id) {
        Goods goods = goodsService.getGoodsById(id);
        return goods;
    }

}
