package cn.baidu;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
        /* 发送邮件的测试程序
        *
        * @author 花2不谢
        *
        */
public class testJavaMail{

    public static void main(String[] args) throws MessagingException {
        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        /*
         * 可用的属性： mail.store.protocol / mail.transport.protocol / mail.host /
         * mail.user / mail.from
         */
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.163.com");
        // 发件人的账号
        props.put("mail.user", "15937643605@163.com");
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "zzj234812");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人
        InternetAddress to = new InternetAddress("2516833515@qq.com");
        message.setRecipient(RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("哈哈");

        // 设置邮件的内容体
        message.setContent("自己发送邮件的内容体666", "text/html;charset=UTF-8");

        // 发送邮件
        Transport.send(message);
    }
}
/*
只需要把那个发送邮件账号、密码，接收放设置为自己的即可。一定要开启发送方的POP3/SMTP/IMAP。


 */