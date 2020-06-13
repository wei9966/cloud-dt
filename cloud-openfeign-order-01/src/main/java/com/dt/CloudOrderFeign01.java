package com.dt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Create By WeiBin on 2020/6/2 15:27
 *
 * @author WB
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class CloudOrderFeign01 {
    public static void main(String[] args) {
        SpringApplication.run(CloudOrderFeign01.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate resultSet() {
        return new RestTemplate();
    }
}
