package com.rhythm.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

public interface AccountDao {

    @Update("update t_account set used = used + #{money}, residue = residue - #{money} where user_id = #{userId}")
    int updateMoney(@Param("userId") Long userId, @Param("money")BigDecimal money);

}
