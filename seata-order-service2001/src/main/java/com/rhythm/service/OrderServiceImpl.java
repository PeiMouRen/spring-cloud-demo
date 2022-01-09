package com.rhythm.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rhythm.dao.OrderDao;
import com.rhythm.entity.Order;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author peixi
 * @Date 2022/1/9
 * @Description
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements IOrderService{

    @Resource
    private OrderDao orderDao;
    @Resource
    private IAccountService accountService;
    @Resource
    private IStorageService storageService;

    @Override
    @GlobalTransactional // 开启seata的全局分布式事务
    public boolean createOrder(Order order) {
        log.info("------------------------订单微服务开始创建订单");
        orderDao.insert(order);

        log.info("------------------------订单微服务开始调用库存微服务，做库存扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------------------------订单微服务开始调用库存微服务，做库存扣减end");

        log.info("------------------------订单微服务开始调用账户微服务，做账户余额扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------------------------订单微服务开始调用账户微服务，做账户余额扣减end");

        log.info("------------------------订单创建完成，订单微服务开始更新订单状态");
        orderDao.updateOrderStatus(order.getId());
        log.info("------------------------订单创建完成，订单微服务开始更新订单状态end");

        log.info("------------------------订单微服务创建订单end");
        return true;
    }
}
