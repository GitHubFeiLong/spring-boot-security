package com.cfl.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "登录成功";
    }

    @RequestMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    public String r1 () {
        return "r1 资源";
    }

    @RequestMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    public String r2 () {
        return "r2 资源";
    }

}
