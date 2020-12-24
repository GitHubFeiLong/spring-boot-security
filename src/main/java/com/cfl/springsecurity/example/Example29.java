package com.cfl.springsecurity.example;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;


/**
 * 类描述：
 * SCryptPasswordEncoder:
 * SCryptPasswordEncoder 实现使用 scrypt 算法对密码进行散列。为了在自定义硬件上击败密码破解，scrypt 是一个故意运行缓慢的算法，它需要大量的内存。与其他自适应单向函数一样，应该将其调整为大约1秒钟来验证系统上的密码。
 * @ClassName Example28
 * @Author msi
 * @Date 2020/12/14 21:47
 * @Version 1.0
 */
public class Example29 {
    public static void main(String[] args) {
        SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
        // Caused by: java.lang.ClassNotFoundException: org.bouncycastle.crypto.generators.SCrypt
        String result = encoder.encode("myPassword");
//        assertTrue(encoder.matches("myPassword", result));
    }
}
