package com.AstroTravel.app.services;

import java.util.Objects;

import com.AstroTravel.app.Utility.GlobalMapHolder;
import com.AstroTravel.app.Utility.Utility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.AstroTravel.app.DTO.EmailDTO;

@Service
public class LoginService {

	private final MailService mailService;
	private final Utility utility;
	private final GlobalMapHolder globalMapHolder;

	public LoginService(MailService mailService, Utility utility, GlobalMapHolder globalMapHolder) {
		this.mailService = mailService;
		this.utility = utility;
		this.globalMapHolder = globalMapHolder;
	}

	public ResponseEntity<Object> loginValidateService(EmailDTO emailDTO) {
			if (Objects.isNull(emailDTO.getOTP()) || (emailDTO.getOTP().isEmpty())) {
				String otp = utility.generateOTP(6, false);
				emailDTO.setOTP(otp);
				mailService.sendOtpOnMail(emailDTO.getEmailId(),otp);
				//Remove this once DB configured
				globalMapHolder.put(emailDTO.getEmailId(),otp);
				return ResponseEntity.status(HttpStatus.OK).body(emailDTO);
			}
			if (!mailService.validateOTP(emailDTO.getEmailId(),emailDTO.getOTP())) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Invalid OTP received!!");
			}
			return ResponseEntity.status(HttpStatus.OK).body("OTP has been successfully validated!!");
	}

}
