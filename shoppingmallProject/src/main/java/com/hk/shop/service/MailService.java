package com.hk.shop.service;


import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SimpleMailMessage preConfiguredMessage;
	
	@Async
	public void sendMail(String to, String subject, String body) {
		// TODO Auto-generated method stub
		
		MimeMessage message = mailSender.createMimeMessage();
		
	}

	@Async
	public void sendPreConfigeredMail(String message) {
		// TODO Auto-generated method stub
		
	}

}
