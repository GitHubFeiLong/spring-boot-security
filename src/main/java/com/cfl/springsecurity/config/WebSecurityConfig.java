package com.cfl.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 类描述：
 *
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author msi
 * @Date 2020/12/29 22:40
 * @Version 1.0
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)   // 开启方法资源拦截
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 定义用户信息服务
     * @return
     */
//    @Bean
//    public UserDetailsService userDetailsService () {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("zhangsan").password("123456").authorities("p1").build());
//        manager.createUser(User.withUsername("lisi").password("123456").authorities("p2").build());
//        return manager;
//    }

    /**
     * 定义密码编码器
     * @return
     */
   /* @Bean
    public PasswordEncoder passwordEncoder () {
        return NoOpPasswordEncoder.getInstance();
    }*/

    /**
     *  BCrypt
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }


    /**
     * 配置安全拦截机制（最重要）
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //  http.authorizeRequests() 方法有多个子节点，每个macher按照他们的声明顺序执行
            .authorizeRequests()
                // 指定"/r/r1"URL，拥有p1权限能够访问
                .antMatchers("/r/r1").hasAuthority("p1")
                // 指定"/r/r2"URL，拥有p2权限能够访问
                .antMatchers("/r/r2").hasAuthority("p2")
                // 指定了"/r/r3"URL，同时拥有p1和p2权限才能够访问
                .antMatchers("/r/r3").access("hasAuthority('p1') and hasAuthority('p2')")
                // 指定了除了r1、r2、r3之外"/r/**"资源，同时通过身份认证就能够访问，这里使用SpEL（Spring Expression Language）表达式
                .antMatchers("/r/**/").authenticated()
                // 剩余的尚未匹配的资源，不做保护
                .anyRequest().permitAll()
            .and()
                // 允许表单登录
                .formLogin()
                // 登录页面，认证失败自动跳到该地址
                .loginPage("/login-view")
                // 自定义登录提交地址
                .loginProcessingUrl("/login")
                // 自定义登录成功的页面地址(认证成功后跳转该地址)
                .successForwardUrl("/login-success")
                // 我们必须允许所有用户访问我们的登录页（例如为验证的用户），这个 formLogin().permitAll() 方法允许任意用户访问基于表单登录的所有的URL。
                .permitAll()
            .and()
                // 提供系统退出支持
                .logout()
                // 设置触发退出操作的URL (默认是 /logout )
                .logoutUrl("/logout")
                // 退出之后跳转的URL。默认是 /login?logout
                .logoutSuccessUrl("/login-view")
                // 定制的 LogoutSuccessHandler ，用于实现用户退出成功时的处理。如果指定了这个选项那么logoutSuccessUrl() 的设置会被忽略。
//                .logoutSuccessHandler(logoutSuccessHandler)
                // 添加一个 LogoutHandler ，用于实现用户退出时的清理工作.默认 SecurityContextLogoutHandler 会被添加为最后一个 LogoutHandler 。
//                .addLogoutHandler(logoutHandler)
                // GET请求
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                // 删除cookie
                .deleteCookies("JSESSIONID")
                // 指定是否在退出时让 HttpSession 无效。 默认设置为 true
                .invalidateHttpSession(true)
            .and()
                .sessionManagement()
                .invalidSessionUrl("/login-view?error=INVALID_SESSION")
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }


}
