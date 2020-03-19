package com.luojia.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.luojia.springcloud.entities.Payment;

@Mapper
public interface PaymentDao {
    /**
     * 新增
     *
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
