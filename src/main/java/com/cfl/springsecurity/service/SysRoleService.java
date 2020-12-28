package com.cfl.springsecurity.service;

import com.cfl.springsecurity.entity.SysRole;
import com.cfl.springsecurity.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @ClassName SysRoleService
 * @Description TODO
 * @Author msi
 * @Date 2020/12/28 21:46
 * @Version 1.0
 */
@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }
}
