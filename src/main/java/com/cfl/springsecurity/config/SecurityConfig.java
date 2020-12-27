//package com.cfl.springsecurity.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import javax.sql.DataSource;
//
///**
// * 类描述：
// *
// * @ClassName SecurityConfig
// * @Description TODO
// * @Author msi
// * @Date 2020/12/24 20:54
// * @Version 1.0
// */
//@Configuration
////@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        // 1.启用内存用户存储
//        auth.inMemoryAuthentication()
//                .withUser("user").password("123456").roles("USER").and()
//                .withUser("admin").password("admin").roles("ADMIN","USER");
//        // 2.JDBC users, authorities, groups, group_members, group_authorities,\,,,,,,,,,,\
//        auth.jdbcAuthentication()
//                .dataSource(dataSource);
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        /**
//         * 对路径 "/spitters/me" 进行验证
//         * 对 "/spittles" post 需要验证
//         * anyRequest，不需要认证和权限
//         */
//        http.formLogin()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/index.html").authenticated()
//                .antMatchers(HttpMethod.POST, "/spittles").authenticated()
//                .anyRequest().permitAll();
//    }
//}
