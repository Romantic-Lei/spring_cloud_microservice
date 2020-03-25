package com.luojia.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
//        try {
//            TimeUnit.MILLISECONDS.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "testA-----";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "...testB ");
        return "testB   -----";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "testD 测试RT-------";
    }
    
    @GetMapping("/testException")
    public String testException(){
        log.info("testException 异常比例");
        int age = 10 /0 ;
        return "testException -----";
    }

    @GetMapping("/testExceptionCount")
    public String testExceptionCount(){
        log.info("testExceptionCount 异常数");
        int age = 10 /0 ;
        return "testExceptionCount -----";
    }
    
    @GetMapping("/testHostKey")
    @SentinelResource(value = "testHostKey", blockHandler = "deal_testHostKey")
    public String testHostKey(@RequestParam(value = "p1", required = false) String p1,
            @RequestParam(value = "p2", required = false) String p2) {
        return "testHostKey----------";
    }
    
    public String deal_testHostKey(String p1, String p2, BlockException exception) {
        return "----------deal_testHostKeyo(╥﹏╥)o";
    }
}