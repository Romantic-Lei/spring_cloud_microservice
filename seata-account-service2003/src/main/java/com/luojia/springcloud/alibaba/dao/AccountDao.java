package com.luojia.springcloud.alibaba.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountDao {

    /**
     * 扣减账户余额
     *
     * @param userId
     * @param money
     * @return
     */
    int decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
