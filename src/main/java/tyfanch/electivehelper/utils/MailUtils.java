package tyfanch.electivehelper.utils;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import tyfanch.electivehelper.constant.config.EmailConfig;

public class MailUtils {
    private MailUtils() {}

    public static void main(String[] args) {
        System.out.println(sendMail(EmailConfig.EMAIL_SUBJECT,
            EmailConfig.EMAIL_SENDER, EmailConfig.EMAIL_RECEIVER,
            "Hello"));
    }

    public static boolean sendMail(String subject, String sendFrom, String sendTo, String content) {
        Properties mailProp = new Properties();
        Authenticator authenticator;
        Session session;
        Message message;
        boolean success;

        try {
            mailProp.setProperty("mail.smtp.host", EmailConfig.EMAIL_HOST);
            mailProp.setProperty("mail.smtp.auth", EmailConfig.EMAIL_AUTH);
            authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(EmailConfig.EMAIL_USER,
                        EmailConfig.EMAIL_PASSWORD);
                }
            };
            session = Session.getInstance(mailProp, authenticator);
            session.setDebug(true);
            // 创建一封邮件
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sendFrom));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }

        return success;
    }
}
