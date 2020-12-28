package com.cfl.springsecurity.service;

import com.cfl.springsecurity.entity.SysUserRole;
import com.cfl.springsecurity.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述：
 *
 * @ClassName SysUserRoleService
 * @Description TODO
 * @Author msi
 * @Date 2020/12/28 21:47
 * @Version 1.0
 */
@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}

