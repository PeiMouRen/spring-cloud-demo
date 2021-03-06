package com.rhythm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 开启eureka client
@EnableDiscoveryClient // 开启discovery服务发现
@MapperScan("com.rhythm.dao") // @Mapper集合，mybatis-plus会结合mapper.xml给该包下所有接口生成实现类
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
