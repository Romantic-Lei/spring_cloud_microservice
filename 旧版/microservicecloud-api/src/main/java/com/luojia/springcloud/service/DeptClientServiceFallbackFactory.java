package com.luojia.springcloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luojia.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component  // 一定不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		
		return new DeptClientService() {

			@Override
			public Dept get(long id) {
				return new Dept().setDeptno(id)
	               .setDname("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
	               .setDb_source("no this database in MySQL");
			}

			@Override
			public List<Dept> list() {
				List list = new ArrayList<Dept>();
//				Dept d = new Dept();
//				d.set
				list.add("没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
				return list;
			}

			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}
}
