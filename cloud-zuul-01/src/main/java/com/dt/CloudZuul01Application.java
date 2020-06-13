package com.dt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author WB
 */
@SpringBootApplication
@EnableZuulProxy
public class CloudZuul01Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuul01Application.class, args);
    }

}
