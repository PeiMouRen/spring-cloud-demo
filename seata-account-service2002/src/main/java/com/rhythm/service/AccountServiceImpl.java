package com.rhythm.service;

import com.rhythm.dao.AccountDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author peixi
 * @Date 2022/1/9
 * @Description
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public int updateMoney(Long userId, BigDecimal money) {
        // 模拟超时异常，触发seata全局事务回滚
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int age = 10/0;
        return accountDao.updateMoney(userId, money);
    }
}
