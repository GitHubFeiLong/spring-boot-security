package com.cfl.springsecurity.service;

import com.cfl.springsecurity.entity.SysUser;
import com.cfl.springsecurity.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @ClassName SysUserService
 * @Description TODO
 * @Author msi
 * @Date 2020/12/28 21:42
 * @Version 1.0
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
