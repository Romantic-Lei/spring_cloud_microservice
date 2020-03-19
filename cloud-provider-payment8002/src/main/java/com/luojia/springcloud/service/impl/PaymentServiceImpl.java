package com.luojia.springcloud.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luojia.springcloud.dao.PaymentDao;
import com.luojia.springcloud.entities.Payment;
import com.luojia.springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
    
    @Resource
    private PaymentDao paymentDao;
    
    // 新增
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    // 根据Id查询
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
