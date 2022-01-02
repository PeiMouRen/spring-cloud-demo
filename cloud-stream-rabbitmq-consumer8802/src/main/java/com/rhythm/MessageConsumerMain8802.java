package com.rhythm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Author peixi
 * @Date 2022/1/1
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class MessageConsumerMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(MessageConsumerMain8802.class, args);
    }
}
