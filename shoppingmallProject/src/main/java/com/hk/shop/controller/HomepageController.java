package com.hk.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.shop.service.EventService;
import com.hk.shop.service.FooterService;
import com.hk.shop.service.ProductService;
import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.ProductVO;
import com.hk.shop.vo.SerchVO;

@Controller
public class HomepageController {
//홈페이지, 상품리스트, 이벤트페이지
	
	@Autowired
	ProductService productService;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	FooterService footerService;
	
	//홈페이지(기본 페이지)
	@RequestMapping (value="/", method= {RequestMethod.GET,RequestMethod.POST})
	String homepage(Model model){
		//이벤트 번호, 이미지 받아서 배너에 이미지, url 넣기
		List<EventVO> eventList = eventService.selectEvents();
		model.addAttribute("eventList", eventList);
		System.out.println("eventList"+eventList.toString());
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
		model.addAttribute("dailyList", dailyList);
		System.out.println("daily"+dailyList.toString());
		
		//여기서 랜덤상품
		List<ProductVO> randomList = productService.selectRandom();
		model.addAttribute("randomList", randomList);
		System.out.println("Random"+randomList.toString());
		//전부 받아서 Model에 넣고 리턴하기
		return"home";
	}
	
	//이벤트 페이지
	@RequestMapping (value="/event/eventList", method= {RequestMethod.GET,RequestMethod.POST})
	String eventpage(Model model, @ModelAttribute EventVO eventVO){
		EventVO eventList = eventService.selectOneEvents(eventVO);
		model.addAttribute("eventList", eventList);
		//이벤트 번호, 이미지 받아서 이벤트 페이지번호에 맞는 화면 구성하기(누른 배너에 따라 번호 받고, 번호에 따른 리스트 가져옴.
		return "event";
	}

	
	//검색페이지
	@RequestMapping (value="/product/serch", method= {RequestMethod.GET,RequestMethod.POST})
	String serch(Model model, @ModelAttribute SerchVO serchVO){

		String serch = serchVO.getSerch();
		
		serchVO.setSerch("%"+serchVO.getSerch()+"%");
		System.out.println(serchVO.getSerch());
		
		List<ProductVO> product;
		product = productService.serchPro(serchVO);
		System.out.println(product.toString());
		model.addAttribute("Product",product);
		model.addAttribute("serch",serch);
		String link;
		if(product.toString()=="[]"){
			link = "serchFail";
		} else {
			link = "serchDone";
		}
		
		return link;
	}
	
	@RequestMapping (value="/footer/companyInfo", method= {RequestMethod.GET,RequestMethod.POST})
	String footerCompanyInfo(Model model){
		//회사정보
		FooterVO footerVO = footerService.selectAll();
		model.addAttribute("footerVO", footerVO);
		String name = "회사정보";
		model.addAttribute("name", name);
		System.out.println(footerVO);
		return "footerCompInfo";
	}
	@RequestMapping (value="/footer/terms", method= {RequestMethod.GET,RequestMethod.POST})
	String footerTems(Model model){
		//이용약관
		FooterVO footerVO = footerService.selectAll();
		System.out.println(footerVO);
		model.addAttribute("footerVO", footerVO);
		String name = "이용약관 및 환불규정";
		model.addAttribute("name", name);
		return "footerTems";
	}
	@RequestMapping (value="/footer/privacy", method= {RequestMethod.GET,RequestMethod.POST})
	String footerPrivacy(Model model){
		//개인정보 처리방침
		FooterVO footerVO = footerService.selectAll();
		model.addAttribute("footerVO", footerVO);
		String name = "개인정보 처리방침";
		model.addAttribute("name", name);
		System.out.println(footerVO);
		return "footerPrivacy";
	}
	
	
	
	@RequestMapping (value="/error", method= {RequestMethod.GET,RequestMethod.POST})
	String errorPage(Model model){
		//에러페이지
		System.out.println("에러페이지입니다.");
		return "warning";
	}

}
