package com.haomu.app.modules.service;

import com.haomu.app.modules.entity.Reserve;
import com.haomu.app.modules.entity.form.CommitReserveForm;
import com.haomu.app.modules.mapper.ReserveMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class ReserveServiceImpl {
    @Resource
    ReserveMapper reserveMapper;

    public int commitReserve(CommitReserveForm form, String wxOpenid){
        Reserve reserve = new Reserve();
        reserve.setWxOpenid(wxOpenid);
        reserve.setReserve_time(form.getReserveTime());
        return reserveMapper.insert(reserve);
    }
}
