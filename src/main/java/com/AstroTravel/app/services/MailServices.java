package com.AstroTravel.app.services;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailServices {

    private final JavaMailSender javaMailSender;

    public MailServices(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String senderMailId, String receiverMailId, String subject, String body) {
        try {
//            log.info("The mail is sending to {} from {}", receiverMailId, senderMailId);
            System.out.println("The mail is sending to {} from");
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(senderMailId);
            mailMessage.setTo(receiverMailId);
            mailMessage.setSubject(subject);
            mailMessage.setText(body);
            // enable when you want to start the sending mail
			javaMailSender.send(mailMessage);
        } catch (Exception e) {
//            log.error("Error accorded while sending mail",e);
        }
    }
}
