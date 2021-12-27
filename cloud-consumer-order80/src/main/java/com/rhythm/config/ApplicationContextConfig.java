package com.rhythm.config;

import com.lbconfig.CustomLoadBalancerConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author peixi
 * @Date 2021/12/23
 * @Description
 */
@Configuration
@LoadBalancerClient(value = "CLOUD-ORDER-SERVICE", configuration = CustomLoadBalancerConfiguration.class)
public class ApplicationContextConfig {

    /**
     * 将RestTemplate注入到spring容器
     * 即：applicationContext.xml <bean id="" class""></bean>
     * @return
     */
    @Bean
    @LoadBalanced // 开启 负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
