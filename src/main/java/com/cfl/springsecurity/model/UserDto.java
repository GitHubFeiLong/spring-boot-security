package com.cfl.springsecurity.model;

import lombok.Data;

/**
 * 类描述：
 * 用户实体类
 * @ClassName UserDto
 * @Author msi
 * @Date 2021/1/2 20:15
 * @Version 1.0
 */
@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
