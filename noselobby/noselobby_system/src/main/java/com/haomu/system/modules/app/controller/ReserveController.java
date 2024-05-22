package com.haomu.system.modules.app.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haomu.common.common.annotation.NeedPermission;
import com.haomu.common.common.util.result.Result;
import com.haomu.common.entity.app.vo.ReserveVO;
import com.haomu.system.modules.app.service.ReserveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/reserveAdmin")
public class ReserveController {

    @Resource
    ReserveService reserveService;

    @NeedPermission("system:app:user:list")
    @GetMapping("/page")
    public Result<Page<ReserveVO>> getuserAdminByPage(@RequestParam(defaultValue = "1") int pageNo,
                                                      @RequestParam(defaultValue = "10") int pageSize) {
        return Result.ok(reserveService.getReserveByPage(pageNo,pageSize));
    }
}
