package com.rhythm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author peixi
 * @Date 2021/12/28
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // 开启open fegin
public class OrderFeginMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeginMain80.class, args);
    }
}
