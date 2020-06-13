package com.dt.pojo;

import lombok.Data;

/**
 * Create By WeiBin on 2020/6/2 15:54
 * @author WB
 */
@Data
public class GoodsOrder {
    private int orderId;
    private int num;
    private int userId;
    private Goods goods;
}
