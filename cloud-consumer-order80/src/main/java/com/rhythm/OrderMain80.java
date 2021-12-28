package com.rhythm;

import com.lbconfig.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient // 开启eureka client
// ！！！！注意这个name指定的是服务提供者的id！！！！！
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRule.class) // 切换ribbion的负载均衡策略
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
