package com.rhythm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rhythm.entities.Payment;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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

}
