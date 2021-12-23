package com.rhythm.config;

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
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
