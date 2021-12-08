package com.hk.shop;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	//야호
	//안녕김한비
	//나는서도히라고
	//모두가 성공!!!! 세현쓰!
<<<<<<< HEAD
	//슬쩍 집에서 연결해봤쉼다 - 세현12/07
	
	// ignore추가후 나도 커밋해볼궤 -도희-
=======
	//슬쩍 집에서 연결해봤쉼다 - 세현12/07'
	//12.08 최세현
//>>>>>>> branch 'master' of https://github.com/choiseHyeon98/shoppingmall.git
}
