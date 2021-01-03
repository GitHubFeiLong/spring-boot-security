package com.cfl.springsecurity.dao;

import com.cfl.springsecurity.model.PermissionDto;
import com.cfl.springsecurity.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 接口描述：
 *
 * @ClassName UserDao
 * @Description TODO
 * @Author msi
 * @Date 2021/1/2 20:17
 * @Version 1.0
 */
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserDto getUserByUsername (String username) {
        String sql = "select id, username, password, fullname from t_user where username = ?";
        List<UserDto> list = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<>(UserDto.class));
        if (list == null && list.size() <= 0) {
            return null;
        }

        return list.get(0);
    }

    /**
     * 根据用户id查询用户权限
     * @param userId
     * @return
     */
    public List<String> findPermissionsByUserId (String userId) {
        String sql = "select * from t_permission where id in (\n" +
                "\tselect permission_id from t_role_permission where role_id in (\n" +
                "\t\tselect role_id from t_user_role where user_id = ?\n" +
                "\t)\n" +
                ")";
        List<PermissionDto> list = jdbcTemplate.query(sql, new Object[]{userId}, new
                BeanPropertyRowMapper<>(PermissionDto.class));

        List<String> codes = list.parallelStream().map(PermissionDto::getCode).collect(Collectors.toList());
        return codes;
    }
}
