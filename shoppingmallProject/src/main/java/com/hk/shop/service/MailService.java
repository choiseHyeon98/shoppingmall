package com.hk.shop.service;


import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service("mailService")
public class MailService {

	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SimpleMailMessage preConfiguredMessage;
	
	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.debug", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.EnableSSL.enable", "true");
		
		javaMailSender.setProtocol("smtp");
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		
		
		return javaMailSender;
	}
	
	@Bean
	public SimpleMailMessage preConfiguredMessage() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		return mailMessage;
	}
	
	@Async
	public void sendMail(String to, String subject, String body) {
		// TODO Auto-generated method stub
		
		
		MimeMessage message = mailSender.createMimeMessage(); // MimeMessage 타입 객체 생성
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper (message, true, "utf-8");
			// messageHelper.setCc("ddh04023@gmail.com"); // 참조인 우리는 필요 없지 
			messageHelper.setFrom("ddh04023@gmail.com", "담당자"); // 보내는 사람
			messageHelper.setSubject("테스트"); //제목
			messageHelper.setTo("ddh04023@naver.com"); // 받는 사람
			messageHelper.setText("테스트 메일입니다."); // 내용
			
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
	
}
