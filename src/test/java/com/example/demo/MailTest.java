package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author
 * @date 2020/9/9
 **/
@SpringBootTest(classes = DemoApplication.class)
public class MailTest {
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        //邮件设置1：一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知");
        message.setText("开会");

        message.setTo("邮箱");
        message.setFrom("邮箱");
        mailSender.send(message);
    }

    /*@Test
    public void contextLoads2() throws MessagingException {
        //邮件设置2：一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("通知-明天来狂神这听课");
        helper.setText("<b style='color:red'>今天 7:30来开会</b>",true);

        //发送附件
        helper.addAttachment("1.jpg",new File(""));
        helper.addAttachment("2.jpg",new File(""));

        helper.setTo("836064520@qq.com");
        helper.setFrom("1157821253@qq.com");

        mailSender.send(mimeMessage);
    }*/
}
