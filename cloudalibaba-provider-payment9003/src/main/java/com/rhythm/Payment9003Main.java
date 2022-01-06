package com.rhythm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author peixi
 * @Date 2022/1/6
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9003Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment9003Main.class, args);
    }
}
