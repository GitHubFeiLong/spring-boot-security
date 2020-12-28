package com.cfl.springsecurity.mapper;

import com.cfl.springsecurity.entity.SysRole;
import org.apache.ibatis.annotations.Select;

/**
 * 接口描述：
 *
 * @ClassName SysRoleMapper
 * @Description TODO
 * @Author msi
 * @Date 2020/12/28 21:39
 * @Version 1.0
 */
public interface SysRoleMapper {
    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    SysRole selectById(Integer id);
}
