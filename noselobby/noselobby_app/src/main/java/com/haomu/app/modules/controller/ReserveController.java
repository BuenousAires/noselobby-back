package com.haomu.app.modules.controller;

import com.haomu.app.common.annotation.NeedLogin;
import com.haomu.app.common.util.SessionUtil;
import com.haomu.app.modules.entity.form.CommitReserveForm;
import com.haomu.app.modules.service.ReserveServiceImpl;
import com.yu.common.common.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/reserve")
public class ReserveController {
    @Resource
    ReserveServiceImpl reserveService;

    @NeedLogin
    @PostMapping("/commit")
    public Result<Integer> commitReserve(@RequestBody CommitReserveForm form, HttpServletRequest request) throws Exception{
        return Result.ok(reserveService.commitReserve(form, SessionUtil.getCurrentWxOpenidFromRequest(request)));
    }
}
