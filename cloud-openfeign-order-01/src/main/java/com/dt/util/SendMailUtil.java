package com.dt.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Create By WeiBin on 2020/6/4 19:38
 * @author WB
 */
@Component
public class SendMailUtil {
    /**
     * 发件人邮箱地址
     */
    @Value("${spring.mail.username}")
    private String from;
    /**
     *  java邮箱发送
     */
    @Resource
    private JavaMailSender javaMailSender;

    /**
     * @param to 收件人地址
     * @param title 邮件标题
     * @param content 邮件内容
     */
    public void sendSimpleMail(String to,String title,String content){
        //邮箱消息
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        javaMailSender.send(message);
    }
}
