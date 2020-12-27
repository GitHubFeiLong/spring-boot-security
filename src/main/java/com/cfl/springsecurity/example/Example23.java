package com.cfl.springsecurity.example;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 类描述：
 * 创建单个用户
 * @ClassName Example23
 * @Author msi
 * @Date 2020/12/14 21:47
 * @Version 1.0
 */
public class Example23 {
    public static void main(String[] args) {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("cfl")
                .password("123456")
                .roles("user")
                .build();

    }
}
