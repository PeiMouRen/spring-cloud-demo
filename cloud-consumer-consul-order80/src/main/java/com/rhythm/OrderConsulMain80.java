package com.rhythm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author peixi
 * @Date 2021/12/27 17:59
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient // 使用consul 注册、发现服务
public class OrderConsulMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }
}
