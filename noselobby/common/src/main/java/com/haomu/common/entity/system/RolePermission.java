package com.haomu.common.entity.system;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_role_permission")
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer roleId;

    private String permission;
}
