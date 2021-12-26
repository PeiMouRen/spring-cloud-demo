package com.rhythm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rhythm.dao.PaymentDao;
import com.rhythm.entities.Payment;
import com.rhythm.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author peixi
 * @Date 2021/12/23 15:48
 * @Description
 *
 * 因为IPaymentService继承了mybatis-plus的IService来添加crud方法，所以这里要继承ServiceImpl
 *
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentDao, Payment> implements IPaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public boolean save(Payment payment) {
        if (paymentDao.insert(payment) > 0)
            return true;
        return false;
    }
}
