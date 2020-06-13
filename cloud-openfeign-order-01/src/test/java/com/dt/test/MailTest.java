package com.dt.test;

import com.dt.CloudOrderFeign01;
import com.dt.util.SendMailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Create By WeiBin on 2020/6/4 19:39
 */
@SpringBootTest(classes = CloudOrderFeign01.class)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class MailTest {
    @Autowired
    private SendMailUtil sendMailUtil;
    @Test
    public void  test2(){
        sendMailUtil.sendSimpleMail("996649855@qq.com","测试邮箱","我是测试内容");
    }
}
