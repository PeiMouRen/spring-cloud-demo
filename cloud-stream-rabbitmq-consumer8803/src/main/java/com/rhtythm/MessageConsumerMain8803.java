package com.rhtythm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author peixi
 * @Date 2022/1/1
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class MessageConsumerMain8803 {

    public static void main(String[] args) {
        SpringApplication.run(MessageConsumerMain8803.class, args);
    }
}
