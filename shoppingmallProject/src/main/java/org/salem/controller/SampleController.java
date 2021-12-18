package org.salem.controller;


import org.salem.service.KakaoPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController {

	@Autowired
	private KakaoPay kakaopay;

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
    public String kakaoPay() {
        System.out.println("kakaoPay post............................................");
        
        return "redirect:" + kakaopay.kakaoPayReady();
 
    }
    
    @GetMapping("/kakaoPaySuccess")
    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
       System.out.println("kakaoPaySuccess get............................................");
        System.out.println("kakaoPaySuccess pg_token : " + pg_token);
        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
        
        return "kakaopayDone";
        
    }

}