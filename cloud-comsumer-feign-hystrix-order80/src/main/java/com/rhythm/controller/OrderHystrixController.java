package com.rhythm.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rhythm.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@DefaultProperties(defaultFallback = "globalFallBack") // 配置全局默认fallback方法
public class OrderHystrixController {

    @Qualifier("defaultPaymentService") // 解决idea检测不到@FeignClient注解中primary为true，从而导致注入PaymentHystrixService时报错的问题
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.payment_OK(id);
    }

//    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler", commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand // 没有指明fallbackMethod，会调用默认的fallbackMethod
    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id) {
        // int i = 10 / 0; // 这里报错后会调fallbackMethod
        return paymentHystrixService.payment_TimeOut(id);
    }

    public String payment_TimeOutHandler(@PathVariable("id") Integer id) {
        return "我是80,请求的8001接口繁忙，稍后重试！o(╥﹏╥)o";
    }

    public String globalFallBack() {
        return "globalMethod: 服务繁忙，请稍后重试！";
    }

}
