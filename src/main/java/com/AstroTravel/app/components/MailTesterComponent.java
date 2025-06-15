package com.AstroTravel.app.components;

import com.AstroTravel.app.services.MailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This class using to test mail service -> Delete once feature implemented.
 */
@Component
public class MailTesterComponent {

    @Value("${spring.mail.username}")
    private String senderId;

    @Value("${mail.receiver}")
    private String reciverId;

    @Value("${mail.subject}")
    private String subject;

    @Value("${mail.body}")
    private String body;

    @Autowired
    private MailServices mailServices;

    public void sendMailToFriend(){
        mailServices.sendMail(senderId,reciverId,subject,body);
    }

}
