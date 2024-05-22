package com.haomu.system.modules.app.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haomu.common.common.annotation.NeedPermission;
import com.haomu.common.common.util.result.Result;
import com.haomu.common.entity.app.User;
import com.haomu.system.modules.app.service.UserAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userAdmin")
public class UserAdminController {
    @Resource
    private UserAdminService userAdminService;

    @NeedPermission("system:app:user:list")
    @GetMapping("/page")
    public Result<Page<User>> getuserAdminByPage(@RequestParam(defaultValue = "1") int pageNo,
                                                 @RequestParam(defaultValue = "10") int pageSize) {
        return Result.ok(userAdminService.getUserAdminByPage(pageNo, pageSize));
    }

    @NeedPermission("system:app:user:update")
    @PutMapping("")
    public Result<Integer> update(@RequestBody User userAdmin) {
        return Result.ok(userAdminService.updateUserAdmin(userAdmin));
    }
}
