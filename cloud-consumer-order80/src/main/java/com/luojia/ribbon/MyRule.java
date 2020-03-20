package com.luojia.ribbon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class MyRule {
    
    @Bean
    public IRule mySelfRule() {
//        // 定义为轮询(默认)，注册进eureka的服务后，若某个服务挂掉，之后依然会轮询访问到
        return new RoundRobinRule();
//        // 定义为随机
//        return new RandomRule();
//          // 定义为重试，如果某个服务提供者挂掉，我们依旧回去访问几次，若果还是失败，就不会再去访问，直到挂掉服务启动
//        return new RetryRule();
        // 定义权重，响应速度越快的实例选择权重越多大。（可以快速点击查询模拟）
//        return new WeightedResponseTimeRule();
        
    }
}
