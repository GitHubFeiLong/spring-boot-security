package com.cfl.springsecurity.service;

import com.cfl.springsecurity.dao.UserDao;
import com.cfl.springsecurity.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @ClassName SpringDataUserDetailService
 * @Description TODO
 * @Author msi
 * @Date 2021/1/2 15:20
 * @Version 1.0
 */
@Service
public class SpringDataUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据账号查询用户信息
     * @param username  账号
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 使用数据库查询用户信息
        UserDto userDto = userDao.getUserByUsername(username);
        if (userDto == null) {
            // 如果用户查不到，返回null，由 provider 抛异常
            return null;
        }
        //
        System.out.println("username = " + username);
        UserDetails userDetails = User.withUsername(userDto.getUsername())
                .password(userDto.getPassword())
                .authorities("p1")
                .build();

        return userDetails;
    }
}
