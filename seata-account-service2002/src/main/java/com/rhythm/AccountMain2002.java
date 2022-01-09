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
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.rhythm.dao")
public class AccountMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(AccountMain2002.class, args);
    }
}
