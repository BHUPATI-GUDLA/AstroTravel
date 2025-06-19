package com.AstroTravel.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AstroTravel.app.DTO.EmailDTO;
import com.AstroTravel.app.services.LoginService;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/Login")
	public ResponseEntity<Object> addEmailId(@RequestBody EmailDTO emailDTO) {
		return loginService.loginValidateService(emailDTO);
	}
}
