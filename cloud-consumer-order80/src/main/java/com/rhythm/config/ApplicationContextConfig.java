package com.rhythm.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author peixi
 * @Date 2021/12/23
 * @Description
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 将RestTemplate注入到spring容器
     * 即：applicationContext.xml <bean id="" class""></bean>
     * @return
     */
    @Bean
    @LoadBalanced // 开启 负载均衡，使用自定义负载算法时不用此注解
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
