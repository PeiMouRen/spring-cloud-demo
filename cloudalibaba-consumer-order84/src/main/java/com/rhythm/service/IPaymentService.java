package com.rhythm.service;

import com.rhythm.handler.FeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author peixi
 * @Date 2022/1/7 9:57
 * @Description
 */
@FeignClient(value = "cloudalibaba-payment-service", fallback = FeignFallback.class)
public interface IPaymentService {

    @GetMapping("/payment")
    String getPayment();
}
