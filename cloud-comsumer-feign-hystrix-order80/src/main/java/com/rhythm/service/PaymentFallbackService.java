package com.rhythm.service;

import org.springframework.stereotype.Component;

/**
 * @Author peixi
 * @Date 2021/12/30 16:19
 * @Description PaymentHystrixService接口的统一回调
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String payment_OK(Integer id) {
        return "payment_ok繁忙，稍后重试！";
    }

    @Override
    public String payment_TimeOut(Integer id) {
        return "payment_TimeOut繁忙，稍后重试！";
    }
}
