
package com.app.emailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
	
	
	private JavaMailSender javaMailSender;


	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public  void sendEmail(String email,String subject,String content) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject(subject);
		mail.setText(content);

		javaMailSender.send(mail);
	}
	public String registerBody() {
		return "Hello User,\n You have successfully registered with us.";
	}
	public String registerSubject() {
		return "Account Registered";
	}
	public String bookBody() {
		return "Hello User,\n You have successfully Booked an Appointment.\n Check your profile for appointment details.";
	}
	public String bookSubject() {
		return "Appointment Booked";
	}
	public String cancelBody() {
		return "Hello User,\n Your appointment has been cancelled.\n Check your profile for more details.";
	}
	public String cancelSubject() {
		return "Appointment Cancelled";
	}
	}

