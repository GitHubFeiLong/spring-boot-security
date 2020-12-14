package com.cfl.springsecurity.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 类描述：
 * NoOpPasswordEncoder:
 * @ClassName Example30
 * @Author msi
 * @Date 2020/12/14 21:47
 * @Version 1.0
 */
@Configuration
public class Example30 {

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
    }
}
