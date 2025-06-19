package com.AstroTravel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AstroTravelApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(AstroTravelApplication.class, args);
//		MailTesterComponent mailTesterComponent = applicationContext.getBean(MailTesterComponent.class);
//		mailTesterComponent.sendMailToFriend();
	}

}
