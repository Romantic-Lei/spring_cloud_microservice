package com.luojia.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;       // 返回码
    private String message;     // 返回信息
    private T data;             // 返回数据
    
    // 不带数据的构造器
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
