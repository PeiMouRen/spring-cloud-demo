package com.rhythm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author peixi
 * @Date 2021/12/31 10:58
 * @Description
 */
@SpringBootApplication
@EnableHystrixDashboard // 开启hystrix dashboard
public class ConsumerDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDashboardMain9001.class, args);
    }
}
