package com.luojia.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {

    public int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
