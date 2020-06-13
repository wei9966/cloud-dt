package com.dt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create By WeiBin on 2020/6/1 12:16
 *
 * @author WB
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private int id;
    private String name;
    private Double price;
    private String port;

    public Goods(int id,String name,Double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
}
