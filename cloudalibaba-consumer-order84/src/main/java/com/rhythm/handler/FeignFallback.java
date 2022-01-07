package com.rhythm.handler;

import com.rhythm.service.IPaymentService;
import org.springframework.stereotype.Component;

/**
 * @Author peixi
 * @Date 2022/1/7 10:12
 * @Description
 */
@Component
public class FeignFallback implements IPaymentService {

    @Override
    public String getPayment() {
        return "feign failed!!!";
    }
}
