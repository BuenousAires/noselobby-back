package com.haomu.common.entity.system;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private String username;
    private Integer roleId;
    private String password;
    private Boolean status;
}
