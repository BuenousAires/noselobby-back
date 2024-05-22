package com.haomu.system.modules.auth.controller;

import com.haomu.common.common.annotation.NeedPermission;
import com.haomu.common.common.util.result.Result;
import com.haomu.system.common.util.session.SessionUtil;
import com.haomu.system.modules.system.entity.dto.SysUserDTO;
import com.haomu.system.modules.system.entity.form.SysUserLoginForm;
import com.haomu.system.modules.system.service.SysUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private SysUserService sysUserService;

    @PostMapping("/login")
    public Result<SysUserDTO> login (@RequestBody SysUserLoginForm sysUserLoginVo, HttpServletRequest request) throws Exception {
        return Result.ok(sysUserService.login(sysUserLoginVo, request));
    }

    @NeedPermission
    @PostMapping("/loginByToken")
    public Result<SysUserDTO> loginByToken(HttpServletRequest request) {
        System.out.println("11111111");
        SysUserDTO sysUserDTO = SessionUtil.getCurrentSysUserDTO(request);
        SessionUtil.setSysUserSession(sysUserDTO);
        return Result.ok(sysUserDTO);
    }
}
