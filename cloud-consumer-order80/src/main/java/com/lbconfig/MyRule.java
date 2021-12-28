package com.lbconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author peixi
 * @Date 2021/12/28 16:43
 * @Description
 */
@Configuration
public class MyRule {

    @Bean
    public IRule getRule() {
        /**
         * 轮询算法原理：rest接口第几次请求 % 服务集群数 = 实际调用服务的下标
         */
        return new RandomRule(); // 切换负载均衡规则为随机
    }
}
