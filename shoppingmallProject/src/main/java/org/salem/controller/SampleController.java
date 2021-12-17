package org.salem.controller;
 


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.salem.service.KakaoPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Setter;

 

@Controller
public class SampleController {
    
    @Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;
    

	@RequestMapping(value = "/kakaoPay", method =RequestMethod.GET)
	String kakaoPayGet() {

		return "kakaoPay";
	}
    
	@RequestMapping(value = "/kakaoPay", method =RequestMethod.POST)
    public String kakaoPay(Model model) {
        System.out.println("kakaoPay post............................................");
        try {
			URL kurl= new URL("http://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection conn = (HttpURLConnection) kurl.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "KakaoAK 5aeeb59d72610df4d9f40616e4a98945");
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			conn.setDoOutput(true); 
			System.out.println(conn.getDate());
			
			String information="cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=item&quantity=1&total_amount=5000&tax_free_amount=0&approval_url=http://localhost:8888/shop&cancel_url=http://localhost:8888/shop&fail_url=http://localhost:8888/shop";
			System.out.println(information);//이 뒤로 코드실행 X
			
			OutputStream giver = conn.getOutputStream();
			System.out.println("outStream");
			DataOutputStream datagiver = new DataOutputStream(giver);
			datagiver.writeBytes(information);
			System.out.println("writeBytes");
			datagiver.close();
			System.out.println("close");

			int ret = conn.getResponseCode();
			System.out.println("ret");
			
			InputStream receiver;
			if(ret==200) {
				//200이 정상통신
				receiver=conn.getInputStream();
			} else {
				receiver=conn.getErrorStream();
			}
			InputStreamReader reader = new InputStreamReader(receiver);
			BufferedReader converter = new BufferedReader(reader);
			
			model.addAttribute("converter",converter.readLine());
			System.out.println(converter.readLine());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "kakaopayDone";
 
    }

    
}