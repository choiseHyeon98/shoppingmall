package com.hk.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.shop.service.ManagerService;
import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.ProductVO;

@Controller
public class ManagerController {
	/*관리자모드 홈페이지	/manager/managerHome
	관리자모드 카테고리별 상세리스트	/manager/category
	관리자모드 이벤트등록 	/manager/eventAdd
	관리자 모드 이벤트 수정	/manager/eventMod
	관리자 상품 등록	/manager/productAdd
	관리자 리뷰등록	/manager/reviewList
	관리자 리뷰 댓글	/manager/reviewComment
	관리자 회원 관리	/manager/memberList
	관리자 주문 관리	/manager/orderList
	관리자 문의 관리	/manager/FAQList
	관리자 문의 댓글	/manager/FAQComment
		
	관리자 -푸터 회사정보 수정	/manager/footerCompanyInfo
	관리자-푸터 이용 약관 및 환불규정	/manager/footerTerms
	관리자-개인정보 처리방침	/manager/footerPrivacy
	*/
	@Autowired
	ManagerService managerService;
	
	@RequestMapping(value="/manager/mangerHome", method= {RequestMethod.GET,RequestMethod.POST})
	public String managerHome(Model model ) {
		//이벤트배너 받아오기
		List<EventVO> eventList = new ArrayList<EventVO>();
		eventList = managerService.eventService();
		
		
		//베스트상품 받아오기
		List<ProductVO> bestList = new ArrayList<ProductVO>();
		bestList = managerService.bestService();
		
		
		//신상품받아오기
		List<ProductVO> newList = new ArrayList<ProductVO>();
		newList = managerService.newService();
		
		
		//오늘배송상품 받아오기
		List<ProductVO> todayList = new ArrayList<ProductVO>();
		todayList = managerService.todayService();
		
		
		//전체상품 리스트 받아오기
		List<ProductVO> allList = new ArrayList<ProductVO>();
		allList = managerService.allService();
		
		
		//푸터받아오기
		List<FooterVO> footerList = new ArrayList<FooterVO>();
		footerList = managerService.footerService();
		
		
		
		model.addAttribute("eventList",eventList);
		model.addAttribute("bestList",bestList);
		model.addAttribute("newList",newList);
		model.addAttribute("todayList",todayList);
		model.addAttribute("allList",allList);
		model.addAttribute("footerList",footerList);
		
	
		//jsp로연결
		return "managerHome";
		
	}
	
	@RequestMapping(value="/event/Add",method=RequestMethod.GET)
	public String eventAdd() {
		
		return "eventAdd";
		
	}
	@RequestMapping(value="/event/Add",method=RequestMethod.POST)
	public String eventAddDone(Model model, @ModelAttribute EventVO eventVO) {
		
		int ret = managerService.eventAddDoneService(eventVO);
		model.addAttribute("ret", ret);
		
		return "eventAddDone";
		//등록이 완료되었습니다 .jsp
		
	}
	
	
	@RequestMapping(value="/manager/bestPro",method= RequestMethod.GET)
	public String category() {
		
		return "bestPro";
		
	}
	
}
