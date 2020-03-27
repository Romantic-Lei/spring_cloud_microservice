package com.luojia.springcloud.alibaba. dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.luojia.springcloud.alibaba.domain.Order;

@Mapper
public interface OrderDao {

    // 新建一个订单
    public void create(Order order);
    // 修改订单状态
    public void update(@Param("userId") Long userId,@Param("status") Integer status);
}
