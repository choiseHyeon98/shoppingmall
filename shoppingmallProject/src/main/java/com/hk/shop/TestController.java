package com.hk.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String test() { 
		// 222
		/// 333
		return "aaa";
		//444
		// 이건 테스트 서도희다 오바
		//이건 한번 해볼레요 - 최세현
	}
}
