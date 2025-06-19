package com.AstroTravel.app.services;

import com.AstroTravel.app.Utility.GlobalMapHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.AstroTravel.app.DTO.EmailDTO;
import com.AstroTravel.app.Utility.Utility;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Service
@Slf4j
public class MailService {

	@Value("${spring.mail.username}")
	private String senderId;

	@Value("${mail.subject}")
	private String subject;

	private final Utility utility;

	// Remove this once used
	@Autowired
	private GlobalMapHolder globalMapHolder;

	public MailService(Utility utility){
		this.utility = utility;
	}

	/**
	 *
	 * @param emailId
	 * @param otp
	 * only use to send email
	 */
	public void sendOtpOnMail(String emailId, String otp){
		utility.sendMail(senderId, emailId, subject, "Hello, " + utility.fetchUserName(emailId) + " This is your One Time Password: " + otp);
	}

	public boolean validateOTP(String emailId, String otp) {
        return otp.equals(globalMapHolder.get(emailId));
    }
}
