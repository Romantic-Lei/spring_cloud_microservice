package com.luojia.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatWayConfig {

    /**
     * 配置了一个id为route-name的路由规则
     * 当访问localhost:9527/guonei的时候，将会转发至https://news.baidu.com/guonei
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        return routes.route("path_route_luojia_guoneiNews", r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
    }
    
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder) {
        Builder routes = routeLocatorBuilder.routes();
        return routes.route("path_route_luojia_guojiNews", r -> r.path("/guoji").uri("https://news.baidu.com/guoji")).build();
    }
}
