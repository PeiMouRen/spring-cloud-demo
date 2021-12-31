package com.rhythm.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author peixi
 * @Date 2021/12/31 17:46
 * @Description
 */
@Configuration
public class GatewayConfig {

    /**
     * 自定义一个路由规则
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route1", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
        .build();
    }
}
