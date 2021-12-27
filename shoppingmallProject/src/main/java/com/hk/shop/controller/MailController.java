package com.hk.shop.controller;

import java.io.PrintWriter;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.shop.vo.MemberVO;



@Controller

public class MailController {

	
	@Autowired
	private JavaMailSender mailSender;
	

	
	@RequestMapping (value="/sendMail.do", method=RequestMethod.GET)
	public void sendSimpleMail (HttpServletRequest request, HttpServletResponse response, @RequestParam("email") String email, HttpSession session) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		MemberVO memberVO = (MemberVO) session.getAttribute("itsme");
		email = memberVO.getEmail();
		System.out.println("email="+email);
		
		PrintWriter out = response.getWriter();
		
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");

			messageHelper.setFrom("ddh04023@gmail.com", "담당자");
			messageHelper.setSubject("[쇼핑몰] 비밀번호 재설정 안내입니다.");
			messageHelper.setTo("email");
			messageHelper.setText("비밀번호 재설정 링크입니다. "
					+ "링크를 통해 새 비밀번호를 설정해주세요"
					+ "http://localhost:8888/shop/ylhqlalfqjsghwotjdwjdfldzmwlfhd");

			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.print("비밀번호 재설정 이메일을 보냈습니다. 메일함을 확인해주세요!");
		
	}
	

}
