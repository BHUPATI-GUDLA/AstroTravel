package com.AstroTravel.app.Utility;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.AstroTravel.app.Errors.InvalidEmailIdException;

@Component
public class Utility {

	@Value("${mail.domain}")
	private List<String> domain;

	private final JavaMailSender javaMailSender;

	private static final String DIGITS = "0123456789";

	private static final String ALPHANUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public Utility(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public boolean validateEmailId(String emailId) throws InvalidEmailIdException {
		for (String ele : domain) {
			String regEx = "^[a-zA-Z0-9+_.-]+@" + ele + ".com";
			if (emailId.matches(regEx)) {
				return true;
			}
		}
		throw new InvalidEmailIdException("Please enter a valid E-mail!!");
	}

	public String fetchUserName(String emailId) {
		// Fetching the userName from EmailId
		String[] name = emailId.split("@");
		return name[0];
	}

	public String generateOTP(Integer num, boolean isAplaNumeric) {
		StringBuilder otp = null;
		String character = isAplaNumeric ? ALPHANUMERIC : DIGITS;
		SecureRandom random = new SecureRandom();
		otp = new StringBuilder(num);

		for (int i = 0; i < num; i++) {
			int index = random.nextInt(character.length());
			otp.append(character.charAt(index));
		}
		return otp.toString();
	}

	public boolean sendMail(String senderMailId, String receiverMailId, String subject, String body) {
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
			return true;
		} catch (Exception e) {
//            log.error("Error accorded while sending mail",e);
			return false;
		}
	}
}
