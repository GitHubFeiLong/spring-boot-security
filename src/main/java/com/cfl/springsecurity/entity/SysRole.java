package com.cfl.springsecurity.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 类描述：
 *
 * @ClassName SysRole
 * @Description TODO
 * @Author msi
 * @Date 2020/12/27 20:51
 * @Version 1.0
 */
@Data
public class SysRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

}

