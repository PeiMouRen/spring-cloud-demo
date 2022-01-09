package com.rhythm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rhythm.entity.Order;

public interface IOrderService extends IService<Order> {

    boolean createOrder(Order order);
}
