package com.rhythm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rhythm.entities.Payment;

/**
 * @Author peixi
 * @Date 2021/12/23 15:45
 * @Description
 *
 * 继承mybaits-plus的IService接口，使mybatis-plus为service添加基本的crud操作，
 * service的实现类要继承ServiceImpl类
 *
 */
public interface IPaymentService extends IService<Payment> {

    /**
     * 插入一条数据
     * @param payment 实体
     * @return true/false
     */
    boolean save(Payment payment);

}
