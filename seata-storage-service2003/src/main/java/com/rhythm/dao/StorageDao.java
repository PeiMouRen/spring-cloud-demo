package com.rhythm.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface StorageDao {
    @Update("update t_storage set used = used + #{count}, residue = residue - #{count} where product_id = #{productId}")
    int updateCount(@Param("productId") Long productId, @Param("count") Integer count);
}
