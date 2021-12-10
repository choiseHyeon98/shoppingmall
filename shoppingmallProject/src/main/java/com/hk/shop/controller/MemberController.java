package com.hk.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.shop.service.MemberService;

@Controller
public class MemberController {
	//Controller
	
	@Autowired
	MemberService memberService;
	
	/*
	@RequestMapping (value="/", method=RequestMethod.GET)
	public String home () {
		return "home"; // 최초 접속이니까 홈페이지
	}
	*/
	
	
	@RequestMapping (value="/member/login", method=RequestMethod.GET)
	public String Login () {
		// Session 설정
		return "login"; // 로그인하는 창
	}
	
	@RequestMapping (value="/member/login", method=RequestMethod.POST)
	public String LoginDone () {
		// 실패했을때는 실패했다고 알려주고 다시 로그인창
		return "loginDone"; // 로그인 성공이면 완료창
	}
	
	@RequestMapping (value="/member/register", method=RequestMethod.GET)
	public String Register () {
		// 회원가입
		return "register"; // 회원가입하는 창
	}
	
	@RequestMapping (value="/member/register", method=RequestMethod.POST)
	public String RegisterDone () {
		return "registerDone"; // 가입 완료 된 창
	}
	
	@RequestMapping (value="/member/findIdPw", method=RequestMethod.GET)
	public String FindIdPw () {
		return "findIdPw"; // 아이디/비번찾기 입력창
	}
	
	@RequestMapping (value="/member/findId", method=RequestMethod.POST)
	public String FindId () {
		return "findId"; // 아이디 찾기 완료
	}
	
	@RequestMapping (value="/member/resetPw", method=RequestMethod.POST)
	public String ResetPw () {
		return "resetPw"; // 앞에서 받은 아이디에 대한 재설정할 비번 받음
	}
	
	@RequestMapping (value="/member/findPw", method=RequestMethod.POST)
	public String FindPw () {
		return "findPw"; // 앞에서 입력된 재설정비번 완료
	}
	
	// 로그아웃...?
	
	
}
