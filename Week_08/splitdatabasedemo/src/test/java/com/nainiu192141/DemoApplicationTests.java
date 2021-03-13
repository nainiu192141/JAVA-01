package com.nainiu192141;

import com.nainiu192141.entity.SysUser;
import com.nainiu192141.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

    @Autowired
    private SysUserService userService;

    @Test
    public void test() {
        for (int i=0; i<100; i++) {
            SysUser user = new SysUser();
            user.setUsername("444"+i);
            int qqq = userService.insertUser(user);
        }
        //SysUser user = userService.findUserByFirstDb(1);
        //log.info("[{}]", user.toString());
    }

}
