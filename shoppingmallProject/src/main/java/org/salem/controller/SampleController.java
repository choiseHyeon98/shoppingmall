package org.salem.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.salem.service.KakaoPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.shop.service.OrderService;
import com.hk.shop.vo.DeliveryVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OrderListVO;

@Controller
public class SampleController {

	@Autowired
	private KakaoPay kakaopay;

	@Autowired
	HttpSession session;

	@Autowired
	OrderService orderservice;

	public KakaoPay getKakaopay() {
		return kakaopay;
	}

	public void setKakaopay(KakaoPay kakaopay) {
		this.kakaopay = kakaopay;
	}

	@RequestMapping(value = "/kakaoPay", method = RequestMethod.GET)
	String kakaoPayGet() {

		return "kakaoPay";
	}

	@PostMapping("/kakaoPay")
	public String kakaoPay(@ModelAttribute OrderListVO orderListVO, @ModelAttribute DeliveryVO delVO,
			HttpSession session, @RequestParam("proName") String proName) {

		MemberVO membervo = (MemberVO) session.getAttribute("login");
		orderListVO.setId(membervo.getId());
		delVO.setId(membervo.getId());

		System.out.println(orderListVO);
		System.out.println(delVO);

		// 아이디, 주문상품명, 주문갯수, 총가격
		System.out.println("kakaoPay post............................................");

		return "redirect:" + kakaopay.kakaoPayReady(orderListVO, proName, delVO);
	}

	@GetMapping("/kakaoPaySuccess")
	public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
		System.out.println("kakaoPaySuccess get............................................");
		System.out.println("kakaoPaySuccess pg_token : " + pg_token);
		model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
		System.out.println(".............................................................");
		System.out.println("session" + session.getAttribute("order"));
		
		session.setAttribute("token", pg_token);
		return "kakaopayGetDone";
	}
	
	@GetMapping("/kakaoPaySuccessDone")
	public String kakaoPaySuccessPost( Model model) {
		System.out.println("kakaoPaySuccess post............................................");

		System.out.println("session" + session.getAttribute("order"));
		// 블루코딩의 유준상씨의 도움을 받아 작성된 코드입니다.
		//1. 세션에서 token과 map값을 받는다.
		Map<String, Object> map = (Map<String, Object>) session.getAttribute("order");
		//2. map에서 값을 꺼내 선언한 값에 넣는다.
		OrderListVO orderList = (OrderListVO) map.get("orderListVO");//주문정보
		DeliveryVO delVo = (DeliveryVO) map.get("delVo");//배달지정보
		String proName = (String) map.get("proName");//상품명
		String token = (String) session.getAttribute("token");//토큰값
		//세션값을 지워야함.
		System.out.println("세션이름들 조회:"+session.getAttributeNames());	
	
		System.out.println("token:"+token);
		System.out.println(orderList);
		System.out.println(delVo);
		System.out.println(proName);
		
		//이페이지에 다시 돌아온다면...? 기능하지 않도록 설정해야함.
		//토큰값을 입력하고...
		//없으면 서비스에 값 입력, 토큰이 이미 들어있으면 수행 안하도록.
		orderList.setToken(token);//토큰값을 orderList에 전송
		System.out.println(orderList.toString());
		
		//1. 토큰을 체크
		String chkToken = orderservice.chkToken(token);
		if(chkToken==""||chkToken==null) {
			//2. 토큰값이 없으면-수행 O		
			//서비스를 통해 값 입력.
			orderservice.newOrder(orderList);
			orderservice.newDel(delVo);
		} else {
			//2. 토큰값이 있으면-수행 X
		}
		//새로고침했을 때 값이 다시 들어가는지 확인하기.
		model.addAttribute("proName", proName);
		model.addAttribute("delVo", delVo);
		model.addAttribute("orderList", orderList);
		return "kakaopayDone";
		
	}
	
	

}