package com.cfl.springsecurity.dao;

import com.cfl.springsecurity.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
