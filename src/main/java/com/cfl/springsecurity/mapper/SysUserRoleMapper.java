package com.cfl.springsecurity.mapper;

import com.cfl.springsecurity.entity.SysUserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 类描述：
 *
 * @ClassName SysUserRoleMapper
 * @Description TODO
 * @Author msi
 * @Date 2020/12/28 21:40
 * @Version 1.0
 */
public interface SysUserRoleMapper {
    @Select("SELECT * FROM sys_user_role WHERE user_id = #{userId}")
    List<SysUserRole> listByUserId(Integer userId);
}
