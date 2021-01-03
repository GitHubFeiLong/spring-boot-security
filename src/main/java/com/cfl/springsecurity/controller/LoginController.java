package com.cfl.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 类描述：
 *
 * @ClassName LoginController
 * @Description TODO
 * @Author msi
 * @Date 2020/12/29 22:55
 * @Version 1.0
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess () {
        // 提示具体用户登陆成功

        return getUserName() + "登录成功";
    }
//    @RequestMapping("/logout")
    public String loginout () {
        return getUserName() + "退出成功";
    }

    @RequestMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p1')") // 拥有p1权限才可以访问
//    @PreAuthorize("hasAnyAuthority('p1', 'p3')") // 拥有多个权限能访问
    public String r1 () {
        return "r1 资源";
    }

    @RequestMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p2')")
    public String r2 () {
        return "r2 资源";
    }

    /**
     *
     * @return
     */
    private String getUserName () {
        // 获取当前用户的信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 用户身份
        Object principal = authentication.getPrincipal();
        if (Objects.isNull(principal)) {
            return "匿名";
        }
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            return userDetails.getUsername();
        } else {
            return principal.toString();
        }

    }

}
