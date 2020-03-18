package com.luojia.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 支付实体
 * @author asus
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id; // id
    private String serial;  //流水号
}
