package com.rhythm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author peixi
 * @Date 2022/1/2
 * @Description
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/helloInfo")
    public String getHelloInfo() {
        return  serverPort + ": Hello nacos";
    }
}
