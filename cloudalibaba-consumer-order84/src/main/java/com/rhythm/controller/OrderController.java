package com.rhythm.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.rhythm.handler.MyHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author peixi
 * @Date 2022/1/6
 * @Description
 */
@RestController
public class OrderController {

    private static final String PAYMENTURL = "http://cloudalibaba-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("order/payment/{id}")
    @SentinelResource(value = "payment",
                    blockHandlerClass = MyHandler.class,
                    blockHandler = "blockHandler",
                    fallbackClass = MyHandler.class,
                    fallback = "fallback",
                    exceptionsToIgnore = IllegalArgumentException.class)
    public String getPayment(@PathVariable("id") Long id) {
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (id == 5) {
            throw new NullPointerException("空指针异常");
        }
        return restTemplate.getForObject(PAYMENTURL + "/payment", String.class);
    }
}
