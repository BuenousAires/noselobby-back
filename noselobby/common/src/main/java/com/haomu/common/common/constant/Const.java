package com.haomu.common.common.constant;

public class Const {
    // 微信
    public static class Wx{
        public static final String appId = "wx1e8950ead5c7ee3b";
        public static final String appSecret = "d3760872c80d4e4b9ec192ec1ce6d13d";
    }

    // ****************** 时间/秒 ************************//
    public static final long COSNT_one_minute = 60;
    public static final long CONST_half_hour = COSNT_one_minute * 30;
    public static final long CONST_one_hour = CONST_half_hour * 2;
    public static final long CONST_one_day = CONST_one_hour * 24;
    public static final long CONST_one_week = CONST_one_day * 7;
    public static final long CONST_half_month = CONST_one_week * 2;
    public static final long CONST_one_month = CONST_half_month * 2;

    //********************** 普通常量 ***************************//
    // 令牌变量名
    public static final String CONST_token = "token";
    // 微信openid
    public static final String CONST_wx_openid = "wxOpenid";
    // sysUserId
    public static final String CONST_sys_user_id = "sysUserId";

    //********************* redis变量前缀 ***************************//
    // 验证码
    public static final String CONST_verify_code_redis_prefix = "verify_code:";

    //************************ 缓存变量名称 ***************************//
    // 用户会话缓存
    public static final String CONST_user_session_map = "user_session_map";
    // 管理员会话缓存
    public static final String CONST_sys_user_session_map = "sys_user_session_map";
}
