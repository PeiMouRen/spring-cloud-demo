package com.rhythm.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author peixi
 * @Date 2021/12/27 17:51
 * @Description
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentzk() {
        return "springcloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
