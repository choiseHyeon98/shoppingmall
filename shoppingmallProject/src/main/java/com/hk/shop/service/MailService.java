package com.hk.shop.service;


import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
	/*
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SimpleMailMessage preConfiguredMessage;
	
	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		
		javaMailSender.setProtocol("smtp");
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(465);
		
		return javaMailSender;
	}
	
	@Async
	public void sendMail(String to, String subject, String body) {
		// TODO Auto-generated method stub
		
		MimeMessage message = mailSender.createMimeMessage(); // MimeMessage 타입 객체 생성
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper (message, true, "utf-8");
			messageHelper.setCc(""); 
			messageHelper.setFrom("ddh04023@gmail.com", "담당자");
			messageHelper.setSubject("");
			messageHelper.setTo(to);
			messageHelper.setText(body);
			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Async
	public void sendPreConfigeredMail(String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
		mailMessage.setText(message);
		mailSender.send(mailMessage);
		
	}
	*/
}
