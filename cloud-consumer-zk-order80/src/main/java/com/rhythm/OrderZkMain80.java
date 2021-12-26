package com.rhythm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author peixi
 * @Date 2021/12/26
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient // 该注解用于向使用consul或zookeeper作为注册中心时注册服务
public class OrderZkMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class, args);
    }
}
