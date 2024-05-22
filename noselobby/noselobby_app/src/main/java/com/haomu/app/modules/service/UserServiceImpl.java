package com.haomu.app.modules.service;


import com.haomu.app.common.util.SessionUtil;
import com.haomu.app.common.util.WeixinUtil;
import com.haomu.app.modules.entity.form.LoginByWeixinForm;
import com.haomu.app.modules.entity.form.UpdateUserForm;
import com.haomu.app.modules.mapper.UserMapper;

import com.haomu.common.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserServiceImpl {

    @Resource
    private UserMapper userMapper;

    // 通过微信登录，没有就注册
    @Transactional
    public User loginByWeixin(LoginByWeixinForm form) throws ServiceException {
        String wxOpenid = WeixinUtil.getWeiXinOpenid(form.getCode());
        if (wxOpenid != null) {
            User user = userMapper.selectById(wxOpenid);
            if (user == null){
                user = new User();
                user.setWxOpenid(wxOpenid);
                user.setStatus(true);
                userMapper.insert(user);
            }
            if (!user.getStatus()){
                throw ServiceException.CONST_user_is_forbidden;
            }

            SessionUtil.setUserSession(user);
            return user;
        }else {
            throw ServiceException.CONST_wx_login_failed;
        }
    }

    public User getUser(String userId) {
        return userMapper.selectById(userId);
    }

    public int updateUser(UpdateUserForm form, String wxOpenid){
        User user = new User();
        user.setWxOpenid(wxOpenid);
        user.setNickName(form.getNickName());
        user.setTelNumber(form.getTelNumber());
        return userMapper.updateById(user);
    }
}
