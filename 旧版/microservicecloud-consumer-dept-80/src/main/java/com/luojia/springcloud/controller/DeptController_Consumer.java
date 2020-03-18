package com.luojia.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.luojia.springcloud.entities.Dept;


@RestController
public class DeptController_Consumer {
	
	/**
	 * 因为我是消费者，所以我不需要提供服务，我只关心消费，所以我就没有service层，这时我们消费就需要使用到restTemplate
	 */
	//private static final String REST_URL_PREFIC = "http://localhost:8001";
	private static final String REST_URL_PREFIC = "http://MICROSERVICECLOUD-DEPT";
	
	/**
	 * 使用restTemplate访问restful接口非常的简单粗暴无脑。
	 * (url, requestMap, ResponseBean.class)这三个参数分别代表REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIC + "/dept/add", dept, Boolean.class);
	}
	
	// @PathVariable 接收请求路径中占位符的值
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIC + "/dept/get/" + id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIC + "/dept/list", List.class);
	}
	
	// 测试@EnableDiscoveryClient，消费端可以调用服务发现
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIC + "/dept/discovery", Object.class);
	}

}
