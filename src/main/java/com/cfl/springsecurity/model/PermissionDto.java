package com.cfl.springsecurity.model;

import lombok.Data;

/**
 * 类描述：
 *
 * @ClassName PermissionDto
 * @Description TODO
 * @Author msi
 * @Date 2021/1/3 14:02
 * @Version 1.0
 */
@Data
public class PermissionDto {
    private String id;
    private String code;
    private String description;
    private String url;
}
