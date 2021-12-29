package com.rhythm.service;

import org.springframework.stereotype.Service;

/**
 * @Author peixi
 * @Date 2021/12/29 17:59
 * @Description
 */
@Service
public class PaymentService {

    public String payment_OK(Integer id) {
        return Thread.currentThread().getName() + ", payment_OK, id: " + id;
    }

    public String payment_TimeOut(Integer id) {
        int timeoutnum = 3;
        try {
            Thread.sleep(timeoutnum * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + ", payment_TimeOut, id: " + id + ", 耗时(秒): " + timeoutnum;
    }

}
