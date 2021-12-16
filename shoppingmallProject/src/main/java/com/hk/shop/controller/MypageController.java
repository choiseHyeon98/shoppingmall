package com.hk.shop.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.shop.service.MypageService;
import com.hk.shop.vo.CartVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ReviewVO;


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
	
	// 내 정보 조회
	// 세션 넣기
	@RequestMapping (value="/s/myinfo", method=RequestMethod.GET)
	// 로그인 하고 POST로 바꿀 예정
	public String Mypageinfo ( Model model, HttpSession session) {
		String id = "";
		MemberVO memberVO = (MemberVO) session.getAttribute("login");
		id = memberVO.getId();
	//	Map<String, Object> map = mypageService.viewMyInfo(id);
	//	model.addAttribute("member", map.get("memberVO"));
		
		return "mypageInfo"; //--> 이게 잘 나오는지
		
	}
	// GET 수정폼
	@RequestMapping (value="s/myinfo/update", method=RequestMethod.GET)
	public String UpdateMyinfo (Model model, HttpSession session) {
		
		return "";
	}

/*
	// 내정보 수정
	@RequestMapping (value="/mypage/update", method=RequestMethod.GET)
	public String MypageUpdate(Model model, @RequestParam("id") String id) {
		Map<String, Object> map = mypageService.selectMyinfo(id);
		
		model.addAttribute("member", map.get("memberVO"));
		return "mypageUpdate";
	}
	
	// 내정보 수정
		@RequestMapping (value="/mypage/update", method=RequestMethod.POST)
		public String MypageUpdateDone(Model model, @ModelAttribute MemberVO memberVO) {
			int ret = mypageService.updateMypage(memberVO);
			model.addAttribute("ret", ret);
			return "mypageUpdateDone";
		}	
*/
	
	@RequestMapping (value="/s/mypage/cart", method=RequestMethod.GET)
	// 로그인 하고 POST로 바꿀 예정
	public String Cart (Model model) {
		
		List<CartVO> cartList = mypageService.myCartList();
		model.addAttribute("cartList", cartList);
		
		return "cartList"; // 장바구니+찜목록 창
	}
	
	
	@RequestMapping (value="/s/mypage/myorders", method=RequestMethod.GET)
	// 로그인 하고 POST로 바꿀 예정
	public String MyOrders (Model model) {
		
		List<OrderListVO> myOrders = mypageService.myOrderList();
		model.addAttribute("myOrders", myOrders);
		
		return "myorders"; // 내 주문기록창
	}
	
	/*
	@RequestMapping (value="/mypage/addReview", method=RequestMethod.GET)
	public String addReview () {
		return "addReview"; // 리뷰 작성창 + 주문기록에서만 들어간다
	}
	*/
	
	
	@RequestMapping (value="/s/mypage/addReview", method= RequestMethod.GET)
	// URL 연결한 후에 POST로 고친다
	public String addReviewDone (Model model, @ModelAttribute ReviewVO reviewVO) {
		int ret = mypageService.insertReview(reviewVO);
		model.addAttribute("ret", ret);
		return "addReviewDone"; // 리뷰 작성창 + 주문기록에서만 들어간다
	}
	
	//method= {RequestMethod.GET,RequestMethod.POST}
	
}
