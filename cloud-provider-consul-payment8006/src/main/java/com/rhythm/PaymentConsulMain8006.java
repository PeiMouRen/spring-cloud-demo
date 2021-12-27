package com.rhythm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author peixi
 * @Date 2021/12/27 17:50
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient // 使用consul注册、发现服务
public class PaymentConsulMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8006.class, args);
    }
}
