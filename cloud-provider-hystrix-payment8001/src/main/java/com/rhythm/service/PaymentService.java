package com.rhythm.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @Author peixi
 * @Date 2021/12/29 17:59
 * @Description
 */
@Service
public class PaymentService {


    //----------------------------------------------降级---------------------------------------

    public String payment_OK(Integer id) {
        return Thread.currentThread().getName() + ", payment_OK, id: " + id;
    }

    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    }) // 设置降级方法为payment_TimeOutHandler，等待时间为3秒，这种方式用来做服务提供方服务降级
    public String payment_TimeOut(Integer id) {
        int timeoutnum = 2;

        // int i = 10 / 0; // 程序报错会调fallbackMethod

        try {
            Thread.sleep(timeoutnum * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + ", payment_TimeOut, id: " + id + ", 耗时(秒): " + timeoutnum + " (*^▽^*)";
    }

    public String payment_TimeOutHandler(Integer id) {
        return Thread.currentThread().getName() + ", payment_TimeOut, id: " + id + "，服务繁忙，稍后重试o(╥﹏╥)o";
    }

    // -----------------------------------熔断-------------------------------

    @HystrixCommand(fallbackMethod = "paymentCircuitBreak_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后打开断路器
    })
    public String paymentCircuitBreak(Integer id){

        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNo = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "，调用成功，流水号：" + serialNo;
    }

    public String paymentCircuitBreak_fallback(Integer id) {
        return "id不能为负数！o(╥﹏╥)o";
    }

}
