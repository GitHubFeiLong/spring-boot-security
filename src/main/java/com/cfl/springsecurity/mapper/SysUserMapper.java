package com.cfl.springsecurity.mapper;

import com.cfl.springsecurity.entity.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * 接口描述：
 *
 * @ClassName SysUserMapper
 * @Description TODO
 * @Author msi
 * @Date 2020/12/28 21:07
 * @Version 1.0
 */
public interface SysUserMapper {
    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser selectById(Integer id);

    @Select("SELECT * FROM sys_user WHERE name = #{name}")
    SysUser selectByName(String name);
}
