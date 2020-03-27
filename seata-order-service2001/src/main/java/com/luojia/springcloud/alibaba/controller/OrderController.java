package com.luojia.springcloud.alibaba.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luojia.springcloud.alibaba.domain.CommonResult;
import com.luojia.springcloud.alibaba.domain.Order;
import com.luojia.springcloud.alibaba.service.OrderService;
import com.luojia.springcloud.alibaba.snowflake.IdGeneratorSnowflake;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;
    
    @GetMapping("order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
    
    // 利用雪花算法生成账单id
    @GetMapping("snowflake")
    public String getIdBySnowflake() {
        // 获取线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() ->{
                System.out.println(idGeneratorSnowflake.snowflakeld());
            });
        }
        threadPool.shutdown();
        return "hello snowflake";
    }
}
