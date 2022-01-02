package com.rhythm;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.rhythm.dao") // @Mapper集合，mybatis-plus会结合mapper.xml给该包下所有接口生成实现类
public class PaymentProviderMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderMain9001.class, args);
    }
}
