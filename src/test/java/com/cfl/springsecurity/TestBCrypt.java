package com.cfl.springsecurity;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 类描述：
 *
 * @ClassName TestBCrypt
 * @Description TODO
 * @Author msi
 * @Date 2021/1/2 15:54
 * @Version 1.0
 */
//@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class TestBCrypt {

    @Test
    public void testBCrypt (){
        // 对密码进行加密
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        String hashpw1 = BCrypt.hashpw("456", BCrypt.gensalt());
        log.info("hashpw: {}", hashpw);
        log.info("hashpw1: {}", hashpw1);

        System.out.println(BCrypt.checkpw("123", hashpw));
        System.out.println( BCrypt.checkpw("123", hashpw1));
    }
}
