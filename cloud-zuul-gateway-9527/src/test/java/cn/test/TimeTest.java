package cn.test;

import java.time.ZonedDateTime;

import org.junit.Test;

public class TimeTest {

    @Test
    public void timeTest() {
        // 默认时区
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
