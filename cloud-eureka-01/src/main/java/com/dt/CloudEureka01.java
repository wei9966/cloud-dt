package com.dt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Create By WeiBin on 2020/6/1 11:33
 *
 * @author WB
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEureka01 {
    public static void main(String[] args) {
        SpringApplication.run(CloudEureka01.class, args);
    }
}
