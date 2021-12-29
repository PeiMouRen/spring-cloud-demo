package com.rhythm.controller;

import com.rhythm.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author peixi
 * @Date 2021/12/29 18:03
 * @Description
 */
@RestController
@Slf4j
public class PaymentHxtrixController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id) {
        String result = paymentService.payment_OK(id);
        log.info("********************result: " + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.payment_TimeOut(id);
        log.info("********************result: " + result);
        return result;
    }


}
