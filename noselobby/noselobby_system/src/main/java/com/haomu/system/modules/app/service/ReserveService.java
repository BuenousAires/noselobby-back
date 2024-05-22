package com.haomu.system.modules.app.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haomu.common.entity.app.Reserve;
import com.haomu.common.entity.app.User;
import com.haomu.common.entity.app.vo.ReserveVO;
import com.haomu.system.modules.app.mapper.ReserveMapper;
import com.haomu.system.modules.app.mapper.UserAdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ReserveService {
    @Resource
    ReserveMapper reserveMapper;

    @Resource
    UserAdminMapper userAdminMapper;

    public Page<ReserveVO> getReserveByPage(int pageNo, int pageSize) {
        Page<Reserve> page = new Page<>(pageNo, pageSize);
        List<ReserveVO> reserveVOList= new ArrayList<>();
        for (Reserve reserve: reserveMapper.selectPage(page,null).getRecords()) {
            User user = userAdminMapper.selectById(reserve.getWxOpenid());
            ReserveVO reserveVO = new ReserveVO();
            reserveVO.setId(reserve.getId());
            reserveVO.setReserveTime(reserve.getReserveTime());
            reserveVO.setNickName(user.getNickName());
            reserveVO.setTelNumber(user.getTelNumber());
            reserveVOList.add(reserveVO);
        }
        Page<ReserveVO> ans = new Page<>(pageNo,pageSize);
        ans.setRecords(reserveVOList);
        return ans;
    }
}
