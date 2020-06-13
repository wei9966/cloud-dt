package com.dt.controller;

import com.dt.pojo.GoodsOrder;
import com.dt.service.OrderService;
import com.dt.util.SendMailUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Create By WeiBin on 2020/6/2 15:29
 *
 * @author WB
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private SendMailUtil sendMailUtil;

    @RequestMapping("/save/goods")
    @HystrixCommand(fallbackMethod = "saveError")
    public Object save(int userId, int goodsId, HttpServletRequest request) throws InterruptedException {
//        String cookie=request.getHeader("cookie");
//        String token=request.getHeader("token");
//        System.out.println("cookie------->"+cookie);
//        System.out.println("token------>"+token);
        log.info("订单服务正在查找中-------->");
        GoodsOrder goodsOrder = new GoodsOrder();
        goodsOrder.setGoods(orderService.saveGoods(userId, goodsId));
        goodsOrder.setNum(10);
        goodsOrder.setUserId(userId);
        goodsOrder.setOrderId(1);
        //休眠超过默认的1s就会发生服务熔断 TimeUnit.SECONDS.sleep(3000);
        return goodsOrder;
    }

    int i = 0;

    public Object saveError(int userId, int goodsId, HttpServletRequest request) {
        log.info("发生服务降级了");
        //设定存放的key
        String saveOrder = "save-order";
        //通过key获取值
        String value = redisTemplate.opsForValue().get(saveOrder);
        //获取请求地址
        StringBuffer requestURL = request.getRequestURL();
        i++;
        System.out.println("---->第[" + i + "]次访问：" + value);
        //判断是否为空来进行发送邮件操作
        if (StringUtils.isBlank(value)) {
            //发送邮件
            sendMailUtil.sendSimpleMail("996649855@qq.com", "服务器故障", "------>紧急邮件，用户下单失败！请尽快处理，访问URL:" + requestURL);
            //存入到redis
            redisTemplate.opsForValue().set(saveOrder, "save-order-failed", 20, TimeUnit.SECONDS);
        } else {
            log.info("邮件已发送,请20S后重试");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", -1);
        map.put("msg", "------》正在排队中，请稍后再试！");
        return map;
    }

}
