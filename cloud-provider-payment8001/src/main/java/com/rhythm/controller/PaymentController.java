package com.rhythm.controller;

import com.rhythm.entities.CommonResult;
import com.rhythm.entities.Payment;
import com.rhythm.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author peixi
 * @Date 2021/12/23 16:26
 * @Description
 */
@Slf4j // 省去private final Logger logger = LoggerFactory.getLogger(当前类名.class);
@RestController
public class PaymentController {

    @Autowired // 只能按type注入，跟@Qualifier配合可按name注入
    //@Resource // 默认按name注入，也可按type注入
    private IPaymentService paymentService;

    @PostMapping("/payment")
    public CommonResult<Long> create(@RequestBody Payment payment) {
        if (paymentService.save(payment)) {
            log.info("paymentService插入数据库成功");
            return new CommonResult<>(200, "插入支付流水成功", payment.getId());
        }
        log.info("paymentService插入数据库失败");
        return new CommonResult<>(501, "插入支付流水失败");
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        log.info("查询结果:" + payment.toString());
        if(payment != null) {
            return new CommonResult<>(200, "success", payment);
        }
        return new CommonResult<>(501, "没有查询到记录");
    }
}
