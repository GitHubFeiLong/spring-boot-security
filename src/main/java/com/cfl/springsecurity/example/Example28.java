package com.cfl.springsecurity.example;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;


/**
 * 类描述：
 * Pbkdf2PasswordEncoder:
 * Pbkdf2PasswordEncoder 实现使用 PBKDF2算法对密码进行散列。为了击败密码破解，PBKDF2是一个故意缓慢的算法。与其他自适应单向函数一样，应该将其调整为大约1秒钟来验证系统上的密码。当需要 FIPS 认证时，该算法是一个很好的选择。
 * @ClassName Example28
 * @Author msi
 * @Date 2020/12/14 21:47
 * @Version 1.0
 */
public class Example28 {
    public static void main(String[] args) {
       Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
       // 0e76deddf59e945b8386ddd60030d9f3980298c522a284f50e1a003998b7c4ecc7ed4576c13feccd
       String result = encoder.encode("myPassword");
//       assertTrue(encoder.matches("myPassword", result));
    }
}
