package com.hk.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.shop.service.EventService;
import com.hk.shop.service.ProductService;
import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.ProductVO;

@Controller
public class HomepageController {
//홈페이지, 상품리스트, 이벤트페이지
	
	@Autowired
	ProductService productService;
	
	@Autowired
	EventService eventService;
	
	//홈페이지(기본 페이지)
	@RequestMapping (value="/", method= {RequestMethod.GET,RequestMethod.POST})
	String homepage(Model model){
		//이벤트 번호, 이미지 받아서 배너에 이미지, url 넣기
		List<EventVO> eventList = eventService.selectEvents();
		model.addAttribute("eventList", eventList);
		//여기서 베스트 상품
		List<ProductVO> bestList = productService.selectBest();
		model.addAttribute("bestList", bestList);
		System.out.println("best"+bestList.toString());
		//여기서 신상품
		List<ProductVO> newList = productService.selectNew();
		model.addAttribute("newList", newList);
		System.out.println("new"+newList.toString());
		//여기서 오늘배송상품
		List<ProductVO> dailyList = productService.selectDaily();
		model.addAttribute("bestDaily", dailyList);
		System.out.println("daily"+dailyList.toString());
		
		//여기서 랜덤상품
		List<ProductVO> RandomList = productService.selectRandom();
		model.addAttribute("bestRandom", RandomList);
		System.out.println("Random"+RandomList.toString());
		//전부 받아서 Model에 넣고 리턴하기
		return"home";
	}
	
	//이벤트 페이지
	@RequestMapping (value="/event/eventList", method= {RequestMethod.GET,RequestMethod.POST})
	String eventpage(Model model, @RequestParam("eventNum") int eventNum){
		EventVO eventList = eventService.selectOneEvents(eventNum);
		model.addAttribute("eventList", eventList);
		//이벤트 번호, 이미지 받아서 이벤트 페이지번호에 맞는 화면 구성하기(누른 배너에 따라 번호 받고, 번호에 따른 리스트 가져옴.
		return "event";
	}
	
	//검색페이지-다같이 만들기로 함

}
