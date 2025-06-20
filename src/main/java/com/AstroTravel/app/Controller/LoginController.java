package com.AstroTravel.app.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.AstroTravel.app.DTO.EmailDTO;
import com.AstroTravel.app.services.LoginService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(allowedHeaders = "*")
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;
	
	@PostMapping("/Login")
	public ResponseEntity<Object> addEmailId(@RequestBody EmailDTO emailDTO) {
		log.info("Hit came for OTP generation email - {} and OTP - {}", emailDTO.getEmailId(), emailDTO.getOTP());
		return loginService.loginValidateService(emailDTO);
	}

	@PostMapping("/Verify")
	public ResponseEntity<Object> validateOtp(@RequestBody EmailDTO emailDTO) {
		log.info("Hit came for verify email - {} and OTP - {}", emailDTO.getEmailId(), emailDTO.getOTP());
		return loginService.validateOtp(emailDTO);
	}
}
