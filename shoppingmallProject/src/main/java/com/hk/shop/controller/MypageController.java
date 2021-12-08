package com.hk.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {

	@RequestMapping (value="/mypage", method = RequestMethod.GET)
	String mypageHome(){
		
		// 접속하면 비밀번호 인증창 으로 연결
		// 성공하면 내 정보 보여주고
		// 실패하면 다시 인증창
		
		// 찜 목록
		// 주문 내역 조회
		// 리뷰 작성창 
		
		return "mypageHome";
	}
	
	/*
	@RequestMapping (value="/mypage/myinfo", method=RequestMethod.POST)
	public String LoginDone (@ModelAttribute MemberVO memberVO, HttpSession session) {
		memberVO = memberService.isExisted(memberVO);
		
		String retUrl = "loginDone";
		
		if (memberVO == )
	}
	*/
	
}
