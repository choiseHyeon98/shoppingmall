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
	OrderService order;

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
		// 블루코딩의 유준상씨의 도움을 받아 작성된 코드입니다.
		Map<String, Object> map = (Map<String, Object>) session.getAttribute("order");
		//맵으로 변환한 다음 세션을 삭제해버리자!
		OrderListVO orderList = (OrderListVO) map.get("orderListVO");
		DeliveryVO delVo = (DeliveryVO) map.get("delVo");
		String proName = (String) map.get("proName");

		System.out.println(orderList);
		System.out.println(delVo);
		System.out.println(proName);

		order.newOrder(orderList);
		order.newDel(delVo);

		// 서비스 연결해서
		// insert하기!
		
		model.addAttribute("proName", proName);
		model.addAttribute("delVo", delVo);
		model.addAttribute("orderList", orderList);
		
		
		

		return "kakaopayDone";
	}

}