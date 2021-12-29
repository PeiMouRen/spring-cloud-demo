package com.rhythm.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-HYSTRIXT-PAYMENT-SERVICE")
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String payment_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String payment_TimeOut(@PathVariable("id") Integer id);
}
