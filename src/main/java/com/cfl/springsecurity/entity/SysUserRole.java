package com.cfl.springsecurity.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 类描述：
 *
 * @ClassName SysUserRole
 * @Description TODO
 * @Author msi
 * @Date 2020/12/27 20:51
 * @Version 1.0
 */
@Data
public class SysUserRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;

}

