package com.rhythm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rhythm.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface OrderDao extends BaseMapper<Order> {


    @Update("update t_order set status = 1 where id = #{id}")
    int updateOrderStatus(@Param("id") Long id);
}
