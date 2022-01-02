package com.rhythm.controller;


import com.rhythm.entities.CommonResult;
import com.rhythm.entities.Payment;
import com.rhythm.lb.LoadBalancer;
import com.sun.jndi.toolkit.url.Uri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @Author peixi
 * @Date 2021/12/23 16:26
 * @Description
 */
@Slf4j // 省去private final Logger logger = LoggerFactory.getLogger(当前类名.class);
@RestController
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8002/";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment")
    public CommonResult<Long> create(@RequestBody Payment payment) {
        log.info("consumer收到的payment：" + payment.toString());
        return restTemplate.postForObject(PAYMENT_URL + "payment", payment, CommonResult.class);
    }

    @PostMapping("/consumer/payment/postForEntity")
    public CommonResult<Long> createEntity(@RequestBody Payment payment) {
        log.info("consumer收到的payment：" + payment.toString());
        ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(PAYMENT_URL + "payment", payment, CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        return new CommonResult<>(444, "postForEntity操作失败！");
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("consumer收到的paymentId：" + id);
        return restTemplate.getForObject(PAYMENT_URL + "payment/" + id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id) {
        log.info("consumer收到的paymentId：" + id);
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "payment/" + id,CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        return new CommonResult<>(444, "getForEntity操作失败！");
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLb() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (serviceInstances == null || serviceInstances.size() == 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(serviceInstances);
        URI uri = serviceInstance.getUri();
        log.info("*****************uri: " + uri);
        return restTemplate.getForObject(serviceInstance.getUri() + "/payment/lb", String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String getPaymentZipkin() {
        return restTemplate.getForObject(PAYMENT_URL + "payment/zipkin", String.class);
    }

}
