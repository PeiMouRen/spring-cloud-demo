package com.rhythm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author peixi
 * @Date 2022/1/2
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerMain83.class, args);
    }
}
