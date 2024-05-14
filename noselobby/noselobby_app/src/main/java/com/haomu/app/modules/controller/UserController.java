package com.haomu.app.modules.controller;

import com.haomu.app.common.annotation.NeedLogin;
import com.haomu.app.common.util.SessionUtil;
import com.haomu.app.modules.entity.User;
import com.haomu.app.modules.entity.form.LoginByWeixinForm;
import com.haomu.app.modules.entity.form.UpdateUserForm;
import com.haomu.app.modules.service.UserServiceImpl;
import com.haomu.common.common.exception.ServiceException;
import com.haomu.common.common.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserServiceImpl userService;

    @PostMapping("/login/weixin")
    public Result<User> loginByWx(@RequestBody LoginByWeixinForm form) throws Exception {
        return Result.ok(userService.loginByWeixin(form));
    }

    @NeedLogin
    @GetMapping("/info")
    public Result<User> getUserInfo(HttpServletRequest request) throws ServiceException {
        User user = userService.getUser(SessionUtil.getCurrentWxOpenidFromRequest(request));
        SessionUtil.setUserSession(user);
        return Result.ok(user);
    }

    @NeedLogin
    @PutMapping
    public Result<Integer> updaterUser(@RequestBody UpdateUserForm form, HttpServletRequest request) throws Exception {
        return Result.ok(userService.updateUser(form, SessionUtil.getCurrentWxOpenidFromRequest(request)));
    }
}
