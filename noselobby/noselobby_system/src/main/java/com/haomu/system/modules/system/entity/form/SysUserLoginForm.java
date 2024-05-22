package com.haomu.system.modules.system.entity.form;

import lombok.Data;

@Data
public class SysUserLoginForm {
    private String username;
    private String password;
    private String uuid; // 用于去redis里面找验证码
    private String verifyCode; // 验证码
    private String ip;
}
