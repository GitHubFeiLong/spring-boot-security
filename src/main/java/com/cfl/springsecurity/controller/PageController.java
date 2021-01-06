package com.cfl.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类描述：
 * 页面
 * @ClassName PageController
 * @Author msi
 * @Date 2021/1/2 19:21
 * @Version 1.0
 */
@Controller
public class PageController {

    @RequestMapping("/login-view")
    public String loginView () {
        return "login";
    }
}
