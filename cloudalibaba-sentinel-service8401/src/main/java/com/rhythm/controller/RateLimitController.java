package com.rhythm.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.rhythm.entities.CommonResult;
import com.rhythm.entities.Payment;
import com.rhythm.handler.CustomerHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author peixi
 * @Date 2022/1/6
 * @Description
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerBlock")
    public CommonResult byResource() {
        return new CommonResult(200, "byResource success", new Payment(2020l, "2020001"));
    }

    public CommonResult handlerBlock() {
        return new CommonResult(444, "byResource error", null);
    }

    @GetMapping("/byGlobalHandler")
    @SentinelResource(value = "byGlobalHandler",
            blockHandlerClass = CustomerHandler.class,
            blockHandler = "blockHandler2",
            fallbackClass = CustomerHandler.class,
            fallback = "fallBackHandler1")
    public CommonResult byGlobalHandler() {
        //int age = 10/0; // 出现异常时返回fallback
        //限流后返回block
        return new CommonResult(200, "byGlobalHandler success", new Payment(2020l, "2020002"));
    }
}
