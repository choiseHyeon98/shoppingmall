package com.hk.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {
//홈페이지, 상품리스트, 이벤트페이지
	@RequestMapping (value="/", method = RequestMethod.GET)
	String homepage(){
		
		//여기서 베스트 상품
		//여기서 
		return"home";
	}
}
