package com.rhythm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author peixi
 * @Date 2022/1/5
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(AppMain8401.class, args);
    }
}
