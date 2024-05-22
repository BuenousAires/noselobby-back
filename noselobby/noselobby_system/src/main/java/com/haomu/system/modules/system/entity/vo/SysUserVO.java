package com.haomu.system.modules.system.entity.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysUserVO {
    @TableId
    private Integer id;

    private String username;

    private Integer roleId;

    private String roleName;

    @ApiModelProperty("账号激活状态")
    private Boolean status;
}
