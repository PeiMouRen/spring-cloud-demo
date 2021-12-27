package com.rhythm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author peixi
 * @Date 2021/12/26
 * @Description
 */
@RestController
public class OrderController {

    private static final String PAYMENT_URL = "http://cloud-payment-service/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
