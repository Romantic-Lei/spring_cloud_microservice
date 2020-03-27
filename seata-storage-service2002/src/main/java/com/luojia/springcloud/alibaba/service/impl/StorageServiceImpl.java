package com.luojia.springcloud.alibaba.service.impl;

import javax.annotation.Resource;

import com.luojia.springcloud.alibaba.dao.StorageDao;
import com.luojia.springcloud.alibaba.service.StorageService;

public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;
    
    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);
    }

}
