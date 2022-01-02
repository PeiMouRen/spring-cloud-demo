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
public class PaymentProviderMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderMain9002.class, args);
    }
}
