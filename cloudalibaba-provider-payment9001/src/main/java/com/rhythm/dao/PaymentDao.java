package com.rhythm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rhythm.entities.Payment;
import org.springframework.stereotype.Repository;

/**
 * @Author Xingzhe Pei
 * @Date 2021/12/23 11:16
 * @Description
 *
 *  继承mybatid-plus的BaseMapper，使mybatis-plus为dao添加基本的crud操作
 *
 */
@Repository
public interface PaymentDao extends BaseMapper<Payment> {

    /**
     * 插入一条记录123
     * @param entity 实体
     * @return 受影响的行数
     */
    @Override
    int insert(Payment entity);
}
