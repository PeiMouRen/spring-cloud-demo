package com.rhythm.controller;


import com.rhythm.entities.CommonResult;
import com.rhythm.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author peixi
 * @Date 2021/12/23 16:26
 * @Description
 */
@Slf4j // 省去private final Logger logger = LoggerFactory.getLogger(当前类名.class);
@RestController
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001/";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        log.info("consumer收到的payment：" + payment.toString());
        return restTemplate.postForObject(PAYMENT_URL + "payment", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("consumer收到的paymentId：" + id);
        return restTemplate.getForObject(PAYMENT_URL + "payment/" + id,CommonResult.class);
    }

}
