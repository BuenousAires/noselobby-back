package com.haomu.system.modules.app.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haomu.common.entity.app.User;
import com.haomu.system.modules.app.mapper.UserAdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserAdminService {
    @Resource
    private UserAdminMapper userAdminMapper;

    /**
     * 分页条件查询
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return Page<UserAdmin>
     */
    public Page<User> getUserAdminByPage(int pageNo, int pageSize) {
        Page<User> page = new Page<>(pageNo, pageSize);
        return userAdminMapper.selectPage(page, null);
    }

    @Transactional
    public int updateUserAdmin(User user) {
        return userAdminMapper.updateById(user);
    }
}
