package com.cfl.springsecurity.example;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 类描述：
 * BCryptPasswordEncoder:
 * BCryptPasswordEncoder 实现使用广泛支持的 bcrypt 算法对密码进行散列。为了使它更加抵抗密码破解，bcrypt 故意变慢。与其他自适应单向函数一样，应该将其调整为大约1秒钟来验证系统上的密码。BCryptPasswordEncoder 的默认实现使用了强度10，如 BCryptPasswordEncoder 的 Javadoc 中所提到的。我们鼓励您在自己的系统上调整和测试强度参数，以便验证密码大约需要1秒钟。
 * @ClassName Example26
 * @Author msi
 * @Date 2020/12/14 21:47
 * @Version 1.0
 */
public class Example26 {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        // $2a$16$biJpLDOoV/GCJWmWx6EnZuQYTBDJqMgBPNzHWLTg6aXWyPcU6Jjfy
        String result = encoder.encode("myPassword");
        assertTrue(encoder.matches("myPassword", result));
    }
}
