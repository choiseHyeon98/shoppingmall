package com.hk.shop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.shop.service.BoardService;
import com.hk.shop.vo.AskVO;
import com.hk.shop.vo.FAQVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	
	@RequestMapping (value="/board/serviceCenter", method= {RequestMethod.GET,RequestMethod.POST})
	String FAQ(Model model) {
		//FAQ 전체 리스트 보기
		List<FAQVO> FAQLists = boardService.allList(); 
		model.addAttribute("FAQLists", FAQLists);
		System.out.println("FAQLists"+FAQLists);
		return "ServiceCenter";
	}
	
	@RequestMapping (value="/board/questionOne", method= {RequestMethod.GET,RequestMethod.POST})
	String FAQView(Model model, @RequestParam("FAQNum") int FAQNum) {
		//FAQ 하나 상세 보기
		List<FAQVO> FAQList = boardService.ViewOne(FAQNum); 
		model.addAttribute("FAQList", FAQList);
		System.out.println("FAQOneList"+FAQList);
		
		return "QuestionOne";
	}
	
	// 내 문의 내역
	@RequestMapping (value="/board/askList", method= {RequestMethod.GET, RequestMethod.POST} )
	String MyAskList(Model model) {
		List <AskVO> myAskList = boardService.myQuestions();
		model.addAttribute("myAskList", myAskList);
		return "myAskList";
	}
	
	// 내 문의 상세보기
	@RequestMapping (value="/board/askOne", method= {RequestMethod.GET, RequestMethod.POST})
	String MyAskOne(Model model, @RequestParam("askNum") int askNum) {
		Map<String, Object> map = boardService.viewMyAsk(askNum);
		model.addAttribute("askOne", map.get("askVO"));
		model.addAttribute("member", map.get("memberVO"));
		return "myAskOne";
	}
}
