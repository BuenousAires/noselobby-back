package com.haomu.app.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId(type = IdType.INPUT)
    private String wxOpenid;
    private String nickName;
    private String telNumber;
    private Boolean status;


    @TableField(exist = false)
    private String token; // 认证令牌，在缓存会话信息的时候生成
}
