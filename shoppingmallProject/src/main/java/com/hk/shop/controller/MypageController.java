package com.hk.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.shop.service.MypageService;
import com.hk.shop.vo.MemberVO;

// 요기에 세션을 넣어야 들어갈때마다 세션체크가 가능하지 않을까

@Controller
public class MypageController {
	
	@Autowired
	MypageService mypageService;

	/*
	@RequestMapping (value="/mypage", method = RequestMethod.GET)
	String mypageHome() {
		
		// Get으로 접속하면 비밀번호 인증창 으로 연결
		// 성공하면 내 정보 보여주고
		// 실패하면 다시 인증창
		
		// 찜 목록
		// 주문 내역 조회
		// 리뷰 작성창 
		
		return ""; // 비번 인증창
	}
	*/
	
	
	@RequestMapping (value="/mypage", method=RequestMethod.GET)
	public String LoginDone (Model model) {
		
		List<MemberVO> mypageInfo = mypageService.myInfoPage();
		
		model.addAttribute("mypageInfo", mypageInfo);
		return "mypageInfo";
		
	}
	
	@RequestMapping (value="/mypage/cart", method=RequestMethod.POST)
	public String Cart () {
		return "cart"; // 장바구니+찜목록 창
	}
	
	@RequestMapping (value="/mypage/orderLists", method=RequestMethod.POST)
	public String MPorderLists () {
		return "MPorderLists"; // 내 주문기록창
	}
	
	@RequestMapping (value="/mypage/addReview", method=RequestMethod.POST)
	public String addReview () {
		return "addReview"; // 리뷰 작성창 + 주문기록에서만 들어간다
	}
	
	
}
