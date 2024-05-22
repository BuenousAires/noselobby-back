package com.haomu.system.modules.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haomu.common.common.exception.ServiceException;
import com.haomu.common.common.util.GeneratorUtil;
import com.haomu.common.entity.system.SysUser;
import com.haomu.system.common.util.session.SessionUtil;
import com.haomu.system.modules.system.entity.dto.SysUserDTO;
import com.haomu.system.modules.system.entity.form.SysUserLoginForm;
import com.haomu.system.modules.system.mapper.RoleMapper;
import com.haomu.system.modules.system.mapper.RolePermissionMapper;
import com.haomu.system.modules.system.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

@Slf4j
@Service
public class SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    RolePermissionMapper rolePermissionMapper;

    public SysUserDTO login(SysUserLoginForm loginVo, HttpServletRequest request) throws Exception {
        SysUser user = sysUserMapper.selectOne(new QueryWrapper<SysUser>()
                .eq("username", loginVo.getUsername())
                .eq("password", GeneratorUtil.md5Base64(loginVo.getPassword())));

        if (user == null) {
            log.error("[管理员登录失败] {}", loginVo);
            throw ServiceException.CONST_login_failed;
        }

        if (!user.getStatus()) {
            log.error("[管理员登录失败 账号冻结] {}", user);
            throw ServiceException.CONST_user_is_forbidden;
        }

        SysUserDTO userDTO = new SysUserDTO();

        BeanUtils.copyProperties(user, userDTO, "password");

        userDTO.setPermissions(new HashSet<>(rolePermissionMapper.selectPermissionByRoleId(user.getRoleId())));
        userDTO.setRoleName(roleMapper.selectById(user.getRoleId()).getName());
        SessionUtil.setSysUserSession(userDTO);

        log.info("[管理员登录] {}", userDTO);
        return userDTO;
    }


}
