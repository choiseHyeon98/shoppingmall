package com.hk.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.shop.service.ManagerService;
import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.ProductVO;

import com.hk.shop.vo.ReviewVO;

@Controller
public class ManagerController {
	/*관리자모드 홈페이지	/manager/managerHome
	관리자모드 카테고리별 상세리스트	/manager/category
	관리자모드 이벤트등록 	/manager/eventAdd
	관리자 모드 이벤트 수정	/manager/eventMod
	관리자 상품 등록	/manager/productAdd
	관리자 리뷰 관리	/manager/reviewList
	관리자 리뷰 댓글	/manager/reviewComment
	관리자 회원 관리리스트	/manager/memberList
	관리자 회원 삭제 /manager/memberDel
	관리자 주문 관리	/manager/orderList
	관리자 문의 관리	/manager/FAQList
	관리자 문의 댓글	/manager/FAQComment
		
	관리자 -푸터 회사정보 수정	/manager/footerCompanyInfo
	관리자-푸터 이용 약관 및 환불규정	/manager/footerTerms
	관리자-개인정보 처리방침	/manager/footerPrivacy
	*/
	@Autowired
	ManagerService managerService;
	
	@RequestMapping(value="/manager/managerHome", method= {RequestMethod.GET,RequestMethod.POST})
	public String managerHome(Model model ) {
		//이벤트배너 받아오기
		List<EventVO> eventList = new ArrayList<EventVO>();
		eventList = managerService.eventService();
		System.out.println("eventlist="+eventList.toString());
		
		
		//베스트상품 받아오기
		List<ProductVO> bestList = new ArrayList<ProductVO>();
		bestList = managerService.bestService();
		System.out.println("bestLis="+bestList.toString());
		
		
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
	
	
	//event배너 추가 폼
	@RequestMapping(value="/manager/event/add",method=RequestMethod.GET)
	public String eventAdd() {
		
		return "eventAdd";
		
	}
	
	//event배너 추가 완료 
	@RequestMapping(value="/manager/event/add",method=RequestMethod.POST)
	public String eventAddDone(Model model, @ModelAttribute EventVO eventVO) {
		
		int ret = managerService.eventAddDoneService(eventVO);
		System.out.println("eventVO="+eventVO.toString());
		model.addAttribute("ret", ret);
		
		return "eventAddDone";
		//등록이 완료되었습니다 .jsp alert
		
	}
	
	//event배너 수정 폼
	@RequestMapping(value="/manager/eventMod" , method=RequestMethod.GET)
	public String eventMod(Model model, @RequestParam("eventNum") EventVO eventNum ) {
		
		EventVO eventVO=managerService.eventModService(eventNum);
		model.addAttribute("eventVO",eventVO);
		
		return "eventMod";
		
		
	}
	
	//event배너 수정 완료
	@RequestMapping(value="/manager/eventMod" , method=RequestMethod.POST)
	public String eventModDone(Model model , @ModelAttribute EventVO eventVO) {
		
		int ret = managerService.eventModDoneService(eventVO);
		model.addAttribute("ret", ret);
		
		
		return "eventModDone";
		//이벤트 폼이 수정되었습니다 alert
	}
	
	//당일배송 상품 전체보기 url
	@RequestMapping(value="/manager/listDaily",method= {RequestMethod.GET , RequestMethod.POST})
	public String listDaily(Model model) {
		
		List<ProductVO> product = new ArrayList<ProductVO>();
		product = managerService.listDailyService();
		model.addAttribute("product", product);
		
		return "productList";
		//productList로 view맞춰서 안에 값만 다르게 넣기 (ex:product.당일배송)
	}
	
	//전체상품 리스트 URL
	@RequestMapping(value="/menager/listAll" , method= {RequestMethod.GET,RequestMethod.POST})
	public String listAll(Model model) {
		
		List<ProductVO> product = new ArrayList<ProductVO>();
		product = managerService.listAllService();
		model.addAttribute("product", product);
		return "productList";
		//productList로 view맞춰서 안에 값만 다르게 넣기
	}
	
	//관리자 상품 등록 폼
	@RequestMapping(value="/manager/productAdd" , method=RequestMethod.GET)
	public String productAdd() {
		
		return "productAdd";
		
	}
	
	//관리자 상품 등록 완료
	@RequestMapping(value="/manager/productAdd" , method=RequestMethod.POST)
	public String productAddDone (Model model, @ModelAttribute ProductVO productVO) {
		
		int ret = managerService.productAddDoneService(productVO);
		model.addAttribute("ret", ret);
		
		return "productAddDone";
	}   //추가가 완료되었습니다 alert
	
	//관리자 리뷰 리스트 
	@RequestMapping(value="/manager/reviewList" , method= {RequestMethod.GET , RequestMethod.POST})
	public String reviewList(Model model) {
		
		List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		reviewList = managerService.reviewListService();
		model.addAttribute("reviewList", reviewList);
		
		return "reviewList";
	}
	
	//관리자 리뷰 삭제
	@RequestMapping(value="/manager/reviewDel" , method= RequestMethod.POST)
	public String reviewDel(Model model , @RequestParam("reviewNum")int reviewNum) {
		
		int ret = managerService.reviewDelService(reviewNum);
		model.addAttribute("ret", ret);
		
		return "reviewDel";
		//리뷰가 삭제되었습니다 alert
	}
	
	
	//관리자 리뷰 댓글 폼 이동 URL/manager/reviewComment
	@RequestMapping(value="/manager/reviewComment",method=RequestMethod.GET)
	public String reviewComment(Model model , @ModelAttribute ReviewVO reviewVO) {
		
		int ret = managerService.reviewCommentSerivce(reviewVO);
		model.addAttribute("ret", ret);
		//update 후 결과받기
		
		
		return "reviewComment";
		//답글작성이 완료되었습니다 alert -> reviewList
		
		
		
	}
	//관리자 회원 관리	/manager/memberList
	@RequestMapping(value="/manager/memberList",method=RequestMethod.GET)
	public String memberList(Model model , @ModelAttribute MemberVO memberVO) {
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList = managerService.memberListService(memberVO);
		model.addAttribute("memberList", memberList);
		
		return "memberList";
		//회원목록
	}

	
	//관리자 회원 삭제 /manager/memberDel
	@RequestMapping(value="/manager/memberDel",method=RequestMethod.POST)
	public String memberDel(Model model ,@RequestParam("id") String id) {
	
		int ret = managerService.memberDelService(id);
		model.addAttribute("ret", ret);
		
		return "memberDel";
		//회원정보가 삭제되었습니다 alert .jsp
	}
	
	//관리자 회원 관리 적용	/manager/memberUpdate

	
	
	
	
	
	
}
