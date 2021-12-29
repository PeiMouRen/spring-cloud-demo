package com.rhythm.controller;

import com.rhythm.entities.CommonResult;
import com.rhythm.entities.Payment;
import com.rhythm.service.PaymentFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author peixi
 * @Date 2021/12/28
 * @Description
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private PaymentFeginService paymentFeginService;

    @PostMapping("/consumer/payment")
    public CommonResult<Long> create(@RequestBody Payment payment) {
        log.info("consumer收到的payment：" + payment.toString());
        return paymentFeginService.create(payment);
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("consumer收到的paymentId：" + id);
        return paymentFeginService.getPaymentById(id);
    }

    @GetMapping("/consumer/feign/timeout")
    public String paymentFeignTimeout() {
        // feign默认等待时间是1s，超时将报Timeout错误，可在yml中配置
        return paymentFeginService.paymentFeignTimeout();
    }
}
