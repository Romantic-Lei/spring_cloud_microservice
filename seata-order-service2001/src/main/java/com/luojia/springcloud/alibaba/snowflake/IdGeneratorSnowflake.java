package com.luojia.springcloud.alibaba.snowflake;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 雪花算法，生成递增无重复id
 * @author asus
 *
 */
@Slf4j
@Component
public class IdGeneratorSnowflake {
    
    // 终端ID 0-31之间
    private long workerId = 0;
    // 数据中心ID 0-31之间
    private long datacenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
    
    @PostConstruct
    public void init() {
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerId:{}", workerId);
        } catch (Exception e) {
            log.info("当前机器的workerId获取失败", e);
            workerId = NetUtil.getLocalhostStr().hashCode();
            log.info("当前机器 workId:{}", workerId);
        }
    }
    
    public synchronized long snowflakeld() {
        return snowflake.nextId();
    }
    
    public synchronized long snowflakeId(long workerId, long datacenterId) {
        IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
    
    public static void main(String[] args) {
        System.out.println(new IdGeneratorSnowflake().snowflakeld());
    }
    
}
