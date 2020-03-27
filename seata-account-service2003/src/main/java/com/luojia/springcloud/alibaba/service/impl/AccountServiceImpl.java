package com.luojia.springcloud.alibaba.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luojia.springcloud.alibaba.dao.AccountDao;
import com.luojia.springcloud.alibaba.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;
    
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("*******->account-service中扣减账户余额开始");
        // 模拟超时异常,全局事务回滚
        /*try {
            // 暂停20秒钟
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        accountDao.decrease(userId, money);
        log.info("*******->account-service中扣减账户余额结束");
    }

}
