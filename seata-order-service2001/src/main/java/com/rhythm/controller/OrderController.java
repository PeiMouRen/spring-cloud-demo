package com.rhythm.controller;

import com.rhythm.entities.CommonResult;
import com.rhythm.entity.Order;
import com.rhythm.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author peixi
 * @Date 2022/1/9
 * @Description
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private IOrderService orderService;

    @PostMapping("/order")
    public CommonResult create(Order order) {
        orderService.createOrder(order);
        return new CommonResult(200, "订单创建成功");
    }

}
