package com.luojia.springcloud.alibaba.service;

import com.luojia.springcloud.alibaba.domain.Order;

public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
