package com.AstroTravel.app.services;

import java.util.Objects;

import com.AstroTravel.app.Controller.LoginController;
import com.AstroTravel.app.Utility.GlobalMapHolder;
import com.AstroTravel.app.Utility.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.AstroTravel.app.DTO.EmailDTO;

@Service
public class LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginService.class);

    private final MailService mailService;
    private final Utility utility;
    private final GlobalMapHolder globalMapHolder;

    public LoginService(MailService mailService, Utility utility, GlobalMapHolder globalMapHolder) {
        this.mailService = mailService;
        this.utility = utility;
        this.globalMapHolder = globalMapHolder;
    }

    public ResponseEntity<Object> loginValidateService(EmailDTO emailDTO) {
        log.info("OTP is generating for {}", emailDTO.getEmailId());
        String otp = utility.generateOTP(6, false);
        emailDTO.setOTP(otp);
        mailService.sendOtpOnMail(emailDTO.getEmailId(), otp);
        globalMapHolder.put(emailDTO.getEmailId(), emailDTO.getOTP());    //Remove this once DB configured
        log.info("After OTP sent on mail {} {}", emailDTO.getEmailId(), emailDTO.getOTP());
        log.info("Global map is updated {}", globalMapHolder.getAll());
        return ResponseEntity.status(HttpStatus.OK).body(emailDTO);
    }

    public ResponseEntity<Object> validateOtp(EmailDTO emailDTO) {
        if (!mailService.validateOTP(emailDTO.getEmailId(), emailDTO.getOTP())) {
            log.info("Validating otp {} {}", emailDTO.getEmailId(), emailDTO.getOTP());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Invalid OTP received!!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(emailDTO);
    }

}
