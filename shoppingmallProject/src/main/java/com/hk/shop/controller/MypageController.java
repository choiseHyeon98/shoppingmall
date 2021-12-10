package com.hk.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.shop.service.MypageService;
import com.hk.shop.vo.CartVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OrderListVO;

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
	// 로그인 하고 POST로 바꿀 예정
	public String LoginDone (Model model) {
		
		List<MemberVO> mypageInfo = mypageService.myInfoPage();
		
		model.addAttribute("mypageInfo", mypageInfo);
		return "mypageInfo";
		
	}
	
	@RequestMapping (value="/mypage/cart", method=RequestMethod.GET)
	// 로그인 하고 POST로 바꿀 예정
	public String Cart (Model model) {
		
		List<CartVO> cartList = mypageService.myCartList();
		model.addAttribute("cartList", cartList);
		
		return "cartList"; // 장바구니+찜목록 창
	}
	
	// 찜 목록에서 이동한 주문창
	@RequestMapping (value="/mypage/orderList", method=RequestMethod.POST)
	// 찜목록 완성하고 POST로 바꿀 예정
	public String CartOrders () {
		
		return "cartOrders";
	}
	
	
	@RequestMapping (value="/mypage/myorders", method=RequestMethod.GET)
	// 로그인 하고 POST로 바꿀 예정
	public String MyOrders (Model model) {
		
		List<OrderListVO> myOrders = mypageService.myOrderList();
		model.addAttribute("myOrders", myOrders);
		
		return "myorders"; // 내 주문기록창
	}
	
	@RequestMapping (value="/mypage/addReview", method=RequestMethod.POST)

	public String addReview () {
		return "addReview"; // 리뷰 작성창 + 주문기록에서만 들어간다
	}
	
	
}
