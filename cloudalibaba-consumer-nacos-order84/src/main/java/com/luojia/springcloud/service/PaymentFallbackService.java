package com.luojia.springcloud.service;

import org.springframework.stereotype.Component;

import com.luojia.springcloud.entities.CommonResult;
import com.luojia.springcloud.entities.Payment;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(444, "服务降级返回----", new Payment(id, "error"));
    }

}
