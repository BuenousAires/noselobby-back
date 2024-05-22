package com.haomu.system.modules.system.controller;

import com.haomu.common.common.annotation.NeedPermission;
import com.haomu.common.common.exception.ServiceException;
import com.haomu.common.common.util.result.Result;
import com.haomu.common.entity.system.Role;
import com.haomu.system.modules.system.mapper.RoleMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleMapper roleMapper;

    @NeedPermission("system:admin:role:list")
    @GetMapping("/list")
    public Result<List<Role>> getAllSysRoles() throws ServiceException {
        return Result.ok(roleMapper.selectList(null));

    }
}
