package com.haomu.common.common.util;

import com.baomidou.mybatisplus.core.toolkit.EncryptUtils;

public class GeneratorUtil {

    /**
     * md5密码加密
     */
    public static String md5Base64(String password) {
        return EncryptUtils.md5Base64(password);
    }

    /**
     * 生成过期时间
     * @param ttl 多少秒后过期
     * @return 过期时间的时间戳，ms
     */
    public static long generateExpireTime(long ttl) {
        return System.currentTimeMillis() + ttl * 1000;
    }
}
