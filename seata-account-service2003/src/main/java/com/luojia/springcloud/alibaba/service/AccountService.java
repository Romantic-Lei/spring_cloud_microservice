package com.luojia.springcloud.alibaba.service;

import java.math.BigDecimal;

public interface AccountService {
    /**
     * 减账户余额
     *
     * @param userId 用户id
     * @param money  金额
     * @return
     */
    void decrease(Long userId, BigDecimal money);
}
