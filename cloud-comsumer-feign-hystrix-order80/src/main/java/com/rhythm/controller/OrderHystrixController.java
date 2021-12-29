package com.rhythm.controller;

import com.rhythm.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author peixi
 * @Date 2021/12/29
 * @Description
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.payment_OK(id);
    }

    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id) {
        return paymentHystrixService.payment_TimeOut(id);
    }

}
