
package com.app.emailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
	
	
	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public  void sendEmail() throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */
		 
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("goyalyash08@gmail.com");
		mail.setSubject("Testing Mail API");
		mail.setText("Hurray ! You have done that dude...");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}
	}

