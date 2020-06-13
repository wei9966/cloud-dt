package com.dt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Create By WeiBin on 2020/6/1 11:56
 *
 * @author WB
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CloudGoodsHystrix01 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGoodsHystrix01.class, args);
    }
}
