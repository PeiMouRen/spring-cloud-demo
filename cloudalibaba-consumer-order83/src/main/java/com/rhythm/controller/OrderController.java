package com.rhythm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author peixi
 * @Date 2022/1/2
 * @Description
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENTURL = "http://cloudalibaba-provider-payment/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/order/payment/helloInfo")
    public String getHelloInfo() {
        return  restTemplate.getForObject(PAYMENTURL + "payment/helloInfo", String.class);
    }
}
