package com.cfl.springsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 类描述：
 * EnableGlobalMethodSecurity: 第一步是启用方法安全性
 * 第二步：修饰方法资源
 *   @Secured("ROLE_USER")
 *   public String secure() {
 *     return "Hello Security";
 *   }
 * @ClassName SpringSecurityApplication
 * @Author msi
 * @Date 2020/12/27 15:14
 * @Version 1.0
 */
@SpringBootApplication
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

}
