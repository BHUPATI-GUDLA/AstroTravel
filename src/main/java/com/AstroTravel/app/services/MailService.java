package com.AstroTravel.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.AstroTravel.app.DTO.EmailDTO;
import com.AstroTravel.app.Utility.Utility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailService {

	@Autowired
	private Utility utility;

	@Value("${spring.mail.username}")
	private String senderId;

	@Value("${mail.subject}")
	private String subject;

	private String receiverId;

	private String body;

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public EmailDTO sendEmail(EmailDTO emailDTO) {
		try {
			if (utility.validateEmailId(emailDTO.getEmailId())) 
			{
				emailDTO.setOTP(utility.generateOTP(6, false));
				// Setting the mailId of the Receiver
				setReceiverId(emailDTO.getEmailId());

				// Setting the Body of the mail to be send
				setBody("Hello, " + utility.fetchUserName(receiverId) + " This is your One Time Password: "+ emailDTO.getOTP());
				utility.sendMail(senderId, receiverId, subject, body);
			}	
			return emailDTO;		
		} catch(Exception e) {
			e.printStackTrace();
			return new EmailDTO("abc@gmail.com", "123456");
		}
		
	}

	public boolean validateOTP(EmailDTO emailDTO) {
		return true;
	}
}
