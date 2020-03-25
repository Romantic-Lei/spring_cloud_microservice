package com.luojia.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.luojia.springcloud.entities.CommonResult;
import com.luojia.springcloud.entities.Payment;

import lombok.extern.slf4j.Slf4j;

@RestController
//@Slf4j
public class CircleBreakerController {

    private static final String SERVICE_URL = "http://nacos-payment-provider";
    
    @Resource
    private RestTemplate restTemplate;
    
    @RequestMapping("/consumer/fallback/{id}")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "paymentSQL/" + id, CommonResult.class);
        
        if(id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        }else if(result.getData() == null) {
            throw new NullPointerException("NullPointerException 无对应记录，空指针异常");
        }
        return result;
    }
    
}
