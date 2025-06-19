package com.AstroTravel.app.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.AstroTravel.app.DTO.EmailDTO;

@Service
public class LoginService {

	@Autowired
	private MailService mailService;

	public ResponseEntity<Object> loginValidateService(EmailDTO emailDTO) {
			String otp = emailDTO.getOTP();
			if (Objects.isNull(otp) || (otp.isEmpty())) {
				return ResponseEntity.status(HttpStatus.OK).body(mailService.sendEmail(emailDTO));
			}
			if (!mailService.validateOTP(emailDTO)) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Invalid OTP received!!");
			}
			return ResponseEntity.status(HttpStatus.OK).body("OTP has been successfully validated!!");
	}

}
