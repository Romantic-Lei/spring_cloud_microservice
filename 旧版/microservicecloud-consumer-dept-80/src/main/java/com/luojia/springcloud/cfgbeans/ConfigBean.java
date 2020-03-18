package com.luojia.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {
	// boot --> spring application.xml  --- @Configuration配置等同于原来的application.xml配置

	@Bean
	@LoadBalanced // Spring Cloud Ribbon 是基于Netflix Ribbon实现的一套客户端  负载均衡的工具
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule() {
		// return new RoundRobinRule(); // 轮询，即按一定规律顺序的执行微服务
		// return new RandomRule(); // 达到的目的，用我们重新选择的随机算法代替默认的轮询
		// RetryRule效果和RoundRobinRule一样，但是当服务提供者出现异常（我们可以模拟成手动关闭8002服务提供者），我们在先前几次访问时会出现错误页面
		// ，但是过几次之后，我们便不再访问异常的服务提供者
		return new RetryRule();
	}
	
}
