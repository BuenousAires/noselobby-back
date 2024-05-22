package com.haomu.system.modules.system.controller;

import com.haomu.common.common.annotation.NeedPermission;
import com.haomu.common.common.exception.ServiceException;
import com.haomu.common.common.util.result.Result;

import com.haomu.system.modules.system.entity.vo.SysUserVO;
import com.haomu.system.modules.system.mapper.SysUserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserMapper sysUserMapper;

    @NeedPermission("system:admin:sysUser:list")
    @GetMapping("/list")
    public Result<List<SysUserVO>> getAllSysUsers() throws ServiceException {
        return Result.ok(sysUserMapper.getAllUserVOs());
    }
}
