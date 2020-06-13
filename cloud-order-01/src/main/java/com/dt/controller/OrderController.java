package com.dt.controller;

import com.dt.pojo.Goods;
import com.dt.service.OrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Create By WeiBin on 2020/6/2 15:29
 *
 * @author WB
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/save/goods")
    public Object save(int userId, int goodsId) {
//        StringUtils.isBlank()
        return orderService.saveGoods(userId, goodsId);
    }


}
