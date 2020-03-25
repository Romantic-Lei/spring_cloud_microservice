package com.luojia.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.luojia.springcloud.entities.CommonResult;
import com.luojia.springcloud.entities.Payment;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "自定义统一异常处理,global handlerException---1");
    }
    
    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "自定义统一异常处理,global handlerException---2");
    }
}
