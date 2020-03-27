package com.luojia.springcloud.alibaba.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luojia.springcloud.alibaba.domain.CommonResult;
import com.luojia.springcloud.alibaba.domain.Order;
import com.luojia.springcloud.alibaba.service.OrderService;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;
    
    @GetMapping("order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
