package com.cfl.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

/**
 * 类描述：
 * 使用@enablewebsecurity 注释，以启用 Spring Security 的 web 安全支持并提供 Spring MVC 集成。
 * 它还扩展了 WebSecurityConfigurerAdapter 并重写了它的一些方法，以设置 web 安全配置的一些细节
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author msi
 * @Date 2020/12/27 14:47
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    /**
     * 方法定义了哪些 URL 路径应该受到保护，哪些不应该受到保护。具体来说,/和/home 路径被配置为不需要任何身份验证。
     * 所有其他路径都必须经过身份验证。
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        // 1.启用内存用户存储
        auth.inMemoryAuthentication()
                .withUser("user").password("123456").roles("USER").and()
                .withUser("admin").password("admin").roles("ADMIN","USER");
        // 2.JDBC users, authorities, groups, group_members, group_authorities,\,,,,,,,,,,\
        auth.jdbcAuthentication()
                .dataSource(dataSource);
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * 用单个用户设置内存中的用户存储。该用户获得用户名、密码密码和 USER 角色。
     * @return
     */
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
