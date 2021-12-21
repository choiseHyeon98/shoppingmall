package org.salem.service;
 
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.salem.domain.KakaoPayApprovalVO;
import org.salem.domain.KakaoPayReadyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hk.shop.vo.DeliveryVO;
import com.hk.shop.vo.OrderListVO;
 
@Service
public class KakaoPay {
    private static final String HOST = "https://kapi.kakao.com";
    
    private KakaoPayReadyVO kakaoPayReadyVO;
    private KakaoPayApprovalVO kakaoPayApprovalVO;
    
    @Autowired
    HttpSession session;
    
    public String kakaoPayReady(OrderListVO orderListVO, String proName, DeliveryVO delVO) {
 
        RestTemplate restTemplate = new RestTemplate();
        
        int a = orderListVO.getOrderCount();
        int b = orderListVO.getTprice();
        String orderCount = String.valueOf(a);
    	String tprice =String.valueOf(b);
    	
    	String id = orderListVO.getId();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "5aeeb59d72610df4d9f40616e4a98945");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");//가맹점번호
        params.add("partner_order_id", "1001");
        params.add("partner_user_id","관리자" );//아이디--  
        params.add("item_name", proName);//주문상품--
        params.add("quantity",orderCount);//주문갯수--//int를 모 orderListVO.getOrderCount()
        params.add("total_amount",tprice);//총가격-- orderListVO.getTprice()
        params.add("tax_free_amount", "100");//비과세
        params.add("approval_url", "http://localhost:8888/shop/kakaoPaySuccess");
        params.add("cancel_url", "http://localhost:8888/shop/listAll");//주문취소
        params.add("fail_url", "http://localhost:8888/shop/product/detail?proNum=1111");//주문성공
 
         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
 
        try {
        	kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
        	
        	Map<String, Object> map = new HashMap<String, Object>();
        	//새로운 통을 만들고
        	//블루코딩의 유준상씨의 도움을 받아 작성된 코드입니다.
        	map.put("kakaoPayReadyVO", kakaoPayReadyVO);
        	map.put("orderListVO", orderListVO);
        	map.put("delVo", delVO);
        	map.put("proName", proName);
        	session.setAttribute("order", map);
        	
        	
        	
            
            System.out.println("" + kakaoPayReadyVO);
            
            return kakaoPayReadyVO.getNext_redirect_pc_url();
 
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "/kakaoPaySuccess";
        
    }
    
    public KakaoPayApprovalVO kakaoPayInfo(String pg_token) {
 
        System.out.println("KakaoPayInfoVO............................................");
        System.out.println("-----------------------------");
        
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "5aeeb59d72610df4d9f40616e4a98945");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
 
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "관리자");
        params.add("pg_token", pg_token);

        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            System.out.println("" + kakaoPayApprovalVO);
          
            return kakaoPayApprovalVO;
        
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
    
}