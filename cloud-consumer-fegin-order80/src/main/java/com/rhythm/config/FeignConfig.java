package com.rhythm.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author peixi
 * @Date 2021/12/29 17:15
 * @Description
 */
@Configuration
public class FeignConfig {

    /**
     * 设置feign打印全日志full
     * @return
     */
    @Bean
    public Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}
