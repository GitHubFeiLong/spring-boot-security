package com.cfl.springsecurity.example;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 类描述：
 * 创建多个用户
 * @ClassName Example23
 * @Author msi
 * @Date 2020/12/14 21:47
 * @Version 1.0
 */
public class Example24 {
    public static void main(String[] args) {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        User user = (User) users
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        User admin = (User) users
                .username("admin")
                .password("password")
                .roles("USER", "ADMIN")
                .build();
    }
}
