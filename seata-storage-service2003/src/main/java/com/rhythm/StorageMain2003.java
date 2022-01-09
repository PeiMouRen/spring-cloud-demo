package com.rhythm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author peixi
 * @Date 2022/1/9
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.rhythm.dao")
public class StorageMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(StorageMain2003.class, args);
    }
}
