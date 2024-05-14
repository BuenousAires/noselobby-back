package com.haomu.app.common.util;

public class GeneratorUtil {
    /**
     * 生成过期时间
     * @param ttl 多少秒后过期
     * @return 过期时间的时间戳，ms
     */
    public static long generateExpireTime(long ttl) {
        return System.currentTimeMillis() + ttl * 1000;
    }
}
