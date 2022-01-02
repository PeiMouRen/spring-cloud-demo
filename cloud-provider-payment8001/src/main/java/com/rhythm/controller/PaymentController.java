package com.rhythm.controller;

import com.rhythm.entities.CommonResult;
import com.rhythm.entities.Payment;
import com.rhythm.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient; // 服务发现bean，可获取到eureka注册中心已注册服务的信息

    @PostMapping("/payment")
    public CommonResult<Long> create(@RequestBody Payment payment) {
        if (paymentService.save(payment)) {
            log.info("paymentService插入数据库成功");
            return new CommonResult<>(200, "插入支付流水成功, serverPort: " + serverPort, payment.getId());
        }
        log.info("paymentService插入数据库失败");
        return new CommonResult<>(501, "插入支付流水失败");
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        log.info("查询结果:" + payment.toString());
        if(payment != null) {
            return new CommonResult<>(200, "查询payment成功, serverPort: " + serverPort, payment);
        }
        return new CommonResult<>(501, "没有查询到记录");
    }

    /**
     * 获取eureka注册中心中已注册服务的信息
     * @return
     */
    @GetMapping("/payment/discovery")
    public Object discovery() {

        // 获取到注册中心的服务列表
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            log.info("******service: " + service);
        }

        // 获取到某个服务的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getLb() {
        return serverPort;
    }

    /**
     * 测试feign超时，让现成睡眠3s
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverPort;
    }


    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hello, I'm zipkin!!!";
    }
}
