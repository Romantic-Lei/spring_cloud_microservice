package com.luojia.springcloud.alibaba.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luojia.springcloud.alibaba.domain.CommonResult;
import com.luojia.springcloud.alibaba.service.AccountService;

@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping(value = "account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功");
    }
}
