package com.haomu.common.common.exception;

import lombok.Data;

@Data
public class ServiceException extends Exception{
    private int code = 400;

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg, int code) {
        super(msg);
        this.code = code;
    }

    // ******************************************************* //
    // ************************ 前台 服务异常 ****************** //
    // ******************************************************* //

    //************************** user *************************//
    public final static ServiceException CONST_user_is_forbidden =
            new ServiceException("用户已被冻结");
    public final static ServiceException CONST_wx_login_failed =
            new ServiceException("通过微信登录失败");
    public final static ServiceException CONST_user_not_login =
            new ServiceException("用户未登录", 10001);
    public final static ServiceException CONST_token_is_not_validate =
            new ServiceException("token无效或已过期", 10001);

    // ******************************************************* //
    // ************************ 后台 服务异常 ****************** //
    // ******************************************************* //
    public final static ServiceException CONST_login_failed =
            new ServiceException("账号不存在或密码错误");

    public final static ServiceException CONST_not_authorized =
            new ServiceException("权限不足", 10002);
}
