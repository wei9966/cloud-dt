package com.dt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author WB
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class CloudConfig01Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfig01Application.class, args);
    }

}
