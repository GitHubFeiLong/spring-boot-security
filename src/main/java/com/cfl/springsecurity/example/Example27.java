package com.cfl.springsecurity.example;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * 类描述：
 * Argon2PasswordEncoder:
 * Argon2PasswordEncoder 实现使用 Argon2算法对密码进行散列。Argon2是密码散列竞赛的优胜者。为了在自定义硬件上击败密码破解，Argon2是一个故意降低速度的算法，需要大量的内存。与其他自适应单向函数一样，应该将其调整为大约1秒钟来验证系统上的密码。目前实现的 Argon2PasswordEncoder 需要 BouncyCastle。
 * @ClassName Example27
 * @Author msi
 * @Date 2020/12/14 21:47
 * @Version 1.0
 */
public class Example27 {
    public static void main(String[] args) {
        Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
        // 报错：Exception in thread "main" java.lang.NoClassDefFoundError: org/bouncycastle/crypto/params/Argon2Parameters$Builder
        String result = encoder.encode("myPassword");
//        assertTrue(encoder.matches("myPassword", result));
    }
}
