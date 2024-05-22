package com.haomu.system.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haomu.common.entity.system.RolePermission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    // 获取角色的权限
    @Select("select permission from sys_role_permission where role_id = #{param1} group by permission;")
    List<String> selectPermissionByRoleId(Integer roleId);

}
