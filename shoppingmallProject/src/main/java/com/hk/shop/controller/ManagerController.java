package com.hk.shop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.shop.service.ManagerService;
import com.hk.shop.service.ProductService;
import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.FAQVO;
import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ProductVO;

import com.hk.shop.vo.ReviewVO;

@Controller
public class ManagerController {
	/*
	 * 관리자모드 홈페이지 /manager/managerHome 
	 * 관리자모드 카테고리별 상세리스트 /manager/category 
	 * 관리자모드이벤트등록 /manager/eventAdd 
	 * 관리자 모드 이벤트 수정 /manager/eventMod 
	 * 관리자 모드 이벤트 삭제 /manager/eventDel
	 * 관리자 상품 등록 /manager/product/add 
	 * 관리자 리뷰 관리 /manager/review/list 
	 * 관리자 리뷰 댓글 /manager/review/comment 
	 * 관리자 회원 관리리스트 /manager/member/list 
	 * 관리자 회원 삭제 /manager/member/del 
	 * 관리자 회원 관리 적용 /manager/member/update
	 * 관리자 주문 관리 /manager/order/list 
	 * 관ㄹ자 주문 취소 /manager/order/cancel
	 * 관리자 문의 관리 /manager/FAQ/list
	 * 관리자 문의 댓글 /manager/FAQ/comment
	 * 관리자 문의 댓글 삭제 /manager/FAQ/del
	 * 관리자 -푸터 회사정보 수정 /manager/footer/companyInfo 
	 * 관리자-푸터 이용 약관 및 환불규정 /manager/footer/terms 
	 * 관리자-개인정보 처리방침 /manager/footer/privacy
	 */
	@Autowired
	ManagerService managerService;
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/manager/managerHome", method = { RequestMethod.GET, RequestMethod.POST })
	public String managerHome(Model model) {
		// 이벤트배너 받아오기
		List<EventVO> eventList = new ArrayList<EventVO>();
		eventList = managerService.eventService();
		System.out.println("eventlist=" + eventList.toString());

		// 베스트상품 받아오기
		List<ProductVO> bestList = new ArrayList<ProductVO>();
		bestList = managerService.bestService();
		System.out.println("bestLis=" + bestList.toString());

		// 신상품받아오기
		List<ProductVO> newList = new ArrayList<ProductVO>();
		newList = managerService.newService();

		// 오늘배송상품 받아오기
		List<ProductVO> todayList = new ArrayList<ProductVO>();
		todayList = managerService.todayService();

		// 전체상품 리스트 받아오기
		List<ProductVO> allList = new ArrayList<ProductVO>();
		allList = managerService.allService();

		// 푸터받아오기
		List<FooterVO> footerList = new ArrayList<FooterVO>();
		footerList = managerService.footerService();

		model.addAttribute("eventList", eventList);
		model.addAttribute("bestList", bestList);
		model.addAttribute("newList", newList);
		model.addAttribute("todayList", todayList);
		model.addAttribute("allList", allList);
		model.addAttribute("footerList", footerList);

		// jsp로연결
		return "managerHome";

	}
	//게시글 삭제 체크박스, 품절처리 체크박스
	@RequestMapping(value="/muldelete",method=RequestMethod.GET)
	  public String proMuldelete(Model model,@RequestParam("chkbox")List<Integer> productNums) {
		  System.out.println("productNums="+productNums.toString());
		//articleNOs를 Service에 전달해서 service에서 for문을 통해 삭제 
		  //그 결과를 model에 넣고 전달
		  //articleNOs=[15,14,13,12,11,10,9]
		   Map<String,Integer> map = managerService.mulSerivcle(productNums);
		 System.out.println("성공한갯수="+map.get("succ"));
		 System.out.println("실패한갯수="+map.get("fail"));
		 model.addAttribute("map", map);
		  return "proMuldelete";
		  
	  }

	// 카테고리별 상세리스트
	// 1.전체상품
	@RequestMapping(value = "/manager/product/listAll", method = { RequestMethod.GET, RequestMethod.POST })
	String allCategory(Model model) {
		List<ProductVO> Product = productService.selectAll();
		model.addAttribute("Product", Product);
		System.out.println("AllList" + Product.toString());
		return "ProductList";
	}

	// 2. 캐주얼 상품
	@RequestMapping(value = "/manager/product/listCasual", method = { RequestMethod.GET, RequestMethod.POST })
	String casualCategory(Model model) {
		List<ProductVO> Product = productService.selectCasual();
		model.addAttribute("Product", Product);
		System.out.println("listCasual" + Product.toString());
		return "ProductList";
	}

	// 3. 오피스 상품/product/listOffice
	@RequestMapping(value = "/manager/product/listOffice", method = { RequestMethod.GET, RequestMethod.POST })
	String officeCategory(Model model) {
		List<ProductVO> Product = productService.selectOffice();
		model.addAttribute("Product", Product);
		System.out.println("listOffice" + Product.toString());
		return "ProductList";
	}

	// 4. 페미닌 상품/product/listFeminine
	@RequestMapping(value = "/manager/product/listFeminine", method = { RequestMethod.GET, RequestMethod.POST })
	String feminineCategory(Model model) {
		List<ProductVO> Product = productService.selectFeminine();
		model.addAttribute("Product", Product);
		System.out.println("listFeminine" + Product.toString());
		return "ProductList";
	}

	// 5. 힙 상품/product/listHip
	@RequestMapping(value = "/manager/product/listHip", method = { RequestMethod.GET, RequestMethod.POST })
	String hipCategory(Model model) {
		List<ProductVO> Product = productService.selectHip();
		model.addAttribute("Product", Product);
		System.out.println("listHip" + Product.toString());
		return "ProductList";
	}

	// 6. 빈티지 상품/product/listVintage
	@RequestMapping(value = "/manager/product/listVintage", method = { RequestMethod.GET, RequestMethod.POST })
	String vintageCategory(Model model) {
		List<ProductVO> Product = productService.selectVintage();
		model.addAttribute("Product", Product);
		System.out.println("listVintage" + Product.toString());
		return "ProductList";
	}

	// 오늘배송
	@RequestMapping(value = "/manager/product/listDaily", method = { RequestMethod.GET, RequestMethod.POST })
	String dailyCategory(Model model) {
		List<ProductVO> Product = productService.selectDaily();
		model.addAttribute("Product", Product);
		return "ProductList";
	}
	// 당일배송 상품 전체보기 url
	@RequestMapping(value = "/manager/listDaily", method = { RequestMethod.GET, RequestMethod.POST })
	public String listDaily(Model model) {

		List<ProductVO> product = new ArrayList<ProductVO>();
		product = managerService.listDailyService();
		model.addAttribute("product", product);

		return "productList";
			// productList로 view맞춰서 안에 값만 다르게 넣기 (ex:product.당일배송)
	}

	// 전체상품 리스트 URL
	@RequestMapping(value = "/menager/listAll", method = { RequestMethod.GET, RequestMethod.POST })
	public String listAll(Model model) {

		List<ProductVO> product = new ArrayList<ProductVO>();
		product = managerService.listAllService();
		model.addAttribute("product", product);
		return "productList";
			// productList로 view맞춰서 안에 값만 다르게 넣기
	}
	
	

	// event배너 추가 폼
	@RequestMapping(value = "/manager/event/add", method = RequestMethod.GET)
	public String eventAdd() {

		return "eventAdd";

	}

	// event배너 추가 완료
	@RequestMapping(value = "/manager/event/add", method = RequestMethod.POST)
	public String eventAddDone(Model model, @ModelAttribute EventVO eventVO) {

		int ret = managerService.eventAddDoneService(eventVO);
		System.out.println("eventVO=" + eventVO.toString());
		model.addAttribute("ret", ret);

		return "eventAddDone";
		// 등록이 완료되었습니다 .jsp alert

	}

	// event배너 수정 폼
	@RequestMapping(value = "/manager/event/mod", method = RequestMethod.GET)
	public String eventMod(Model model, @RequestParam("eventNum") int eventNum) {

		EventVO eventVO = managerService.eventModService(eventNum);
		model.addAttribute("eventVO", eventVO);

		return "eventMod";

	}
	

	// event배너 수정 완료
	@RequestMapping(value = "/manager/event/mod", method = RequestMethod.POST)
	public String eventModDone(Model model, @ModelAttribute EventVO eventVO) {

		int ret = managerService.eventModDoneService(eventVO);
		System.out.println("eventVO 수정" + eventVO.toString());

		model.addAttribute("ret", ret);

		return "eventModDone";
		// 이벤트 폼이 수정되었습니다 alert
	}
	
	//event 배너 삭제
	@RequestMapping(value="/manager/event/del",method=RequestMethod.POST)
	public String eventDel(Model model, @RequestParam("eventNum")int eventNum) {
		
		int ret = managerService.eventDelService(eventNum);
		model.addAttribute("ret", ret);
		
		return "eventDel";
	}
	

	// 관리자 상품 등록 폼
	@RequestMapping(value = "/manager/product/add", method = RequestMethod.GET)
	public String productAdd() {

		return "productAdd";

	}

	// 관리자 상품 등록 완료
	@RequestMapping(value = "/manager/product/add", method = RequestMethod.POST)
	public String productAddDone(Model model, @ModelAttribute ProductVO productVO) {

		int ret = managerService.productAddDoneService(productVO);
		model.addAttribute("ret", ret);

		return "productAddDone";
	} // 추가가 완료되었습니다 alert

	
	// 관리자 리뷰 리스트
	@RequestMapping(value = "/manager/review/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String reviewList(Model model) {

		List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		reviewList = managerService.reviewListService();
		
		System.out.println("reviewList="+reviewList.toString());
		
		model.addAttribute("reviewList", reviewList);

		return "reviewList";
	}

	//관리자 리뷰 댓글 작성 폼이동 /manager/reviewComment
	@RequestMapping(value = "/manager/review/comment", method = RequestMethod.GET)
	public String reviewComment(Model model, @RequestParam("reviewNum") int reviewNum) {

		ReviewVO reviewVO = managerService.reviewCommentSerivce(reviewNum);
		System.out.println("comment="+reviewVO.toString());
		model.addAttribute("reviewVO", reviewVO);

		return "reviewComment";

	}

	// 관리자 리뷰 댓글 작성 URL/manager/reviewComment ->update
	@RequestMapping(value = "/manager/review/comment", method = RequestMethod.POST)
	public String reviewCommentDone(Model model, @ModelAttribute ReviewVO reviewVO) {

		int ret = managerService.reviewCommentDoneSerivce(reviewVO);
		
		model.addAttribute("ret", ret);
		// update 후 결과받기

		return "reviewCommentDone";
		// 답글작성이 완료되었습니다 alert -> reviewList

	}
	
	// 관리자 리뷰 삭제 -> update? 나중에 get 지우기 
	@RequestMapping(value = "/manager/review/del", method = {RequestMethod.GET,RequestMethod.POST})
	public String reviewDel(Model model, @RequestParam("reviewNum") int reviewNum) {

		int ret = managerService.reviewDelService(reviewNum);
		
		model.addAttribute("ret", ret);

		return "reviewDel";
		// 리뷰가 삭제되었습니다 alert
	}
	
	// 관리자 회원 관리 /manager/memberList
	@RequestMapping(value = "/manager/member/list", method = RequestMethod.GET)
	public String memberList(Model model) {

		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList = managerService.memberListService();
		model.addAttribute("memberList", memberList);
		
		System.out.println("memberList="+memberList.toString());

		return "memberList";
		// 회원목록
	}

	// 관리자 회원 삭제 /manager/memberDel
	@RequestMapping(value = "/manager/member/del", method = {RequestMethod.GET,RequestMethod.POST})
	public String memberDel(Model model, @RequestParam("id") String id) {

		int ret = managerService.memberDelService(id);
		model.addAttribute("ret", ret);
		
		System.out.println("memberDel="+ret);
		return "memberDel";
		// 회원정보가 삭제되었습니다 alert .jsp
	}

	// 관리자 회원 관리 적용 /manager/memberUpdate
	@RequestMapping(value="/manager/member/update",method= {RequestMethod.GET,RequestMethod.POST})
	public String memberUpdate(Model model,@ModelAttribute MemberVO memberVO) {
		//등급설정, 블랙리스트 체크박스 정보 업데이트
		
		int ret =managerService.memberUpdateService(memberVO);
		model.addAttribute("ret", ret);
		
		System.out.println("memberUpdate="+ret);
		
		return "memberUpdate";
	}
	//관리자 주문 관리 /manager/order/list 
	
	@RequestMapping(value="/manager/order/list",method= {RequestMethod.GET,RequestMethod.POST})
	public String memberOrderList(Model model) {
		
		List<OrderListVO> orderList = new ArrayList<OrderListVO>(); 
		orderList = managerService.memberOrderListService();
		System.out.println("orderList=" + orderList.toString());
		
		model.addAttribute("orderList", orderList);
		
		return "memberOrderList";
	}
	
	// lists  -> VO 1ro,, VO 2
	// 
	
	
	//관리자 주문 한개 주문 선택 /manager/order/cancel
	
	//관ㄹ자 주문 취소 /manager/order/cancel
	
	@RequestMapping(value="/manager/order/cancle",method= {RequestMethod.GET,RequestMethod.POST})
	public String orderCancel(Model model, @RequestParam("orderNum")int orderNum) {
		
		int ret = managerService.memberOrderCancleService(orderNum);
		System.out.println("orderNum="+orderNum);
		model.addAttribute("ret", ret);
		
		
		//update로 주문상태 환불로 변경 하시겠습니까?
		return "orderCnacel";
	}
	
	//관리자 주문관리 변경 저장 /manager/order/update
	//수정해야됨
	//orderNum하고 delStatus하고 한방에 가져와야됨
	@RequestMapping(value="/manager/order/update",method= {RequestMethod.GET,RequestMethod.POST})
	public String orderUpdate (Model model , @ModelAttribute OrderListVO orderVO) {
		
		int ret = managerService.memberOrderUpdateService(orderVO);
		
		System.out.println("orderupdate="+orderVO.toString());
		model.addAttribute("ret", ret);
		System.out.println("memberOrderList="+ret);
		
		return "orederUpdate";
	}
	
	//관리자 문의 관리 /manager/FAQ/list
	@RequestMapping(value="/manager/FAQ/list",method= {RequestMethod.GET,RequestMethod.POST})
	public String FAQList(Model model) {
		
		List<FAQVO> FAQList = new ArrayList<FAQVO>(); 
		FAQList = managerService.FAQListService();
		
		model.addAttribute("FAQList", FAQList);
		System.out.println("FAQList="+FAQList.toString());
		
		return "FAQList";
	}
	
	//관리자 문의 댓글 /manager/FAQ/comment->update
	@RequestMapping(value = "/manager/FAQ/comment", method = {RequestMethod.GET,RequestMethod.POST})
	public String FAQComment(Model model, @ModelAttribute FAQVO faqVO) {

		int ret = managerService.reviewCommentSerivce(faqVO);
		model.addAttribute("ret", ret);
		// update 후 결과받기

		return "reviewComment";
		// 답글작성이 완료되었습니다 alert -> reviewList
//
	}
	
	
	
	//관리자 -푸터 회사정보 수정 /manager/footer/companyInfo 
	@RequestMapping(value = "/manager/footer/companyInfo", method = {RequestMethod.GET,RequestMethod.POST})
	public String companyInfoUpdate(Model model, @ModelAttribute FooterVO footerVO) {

		int ret = managerService.companyInfoUpdateSerivce(footerVO);
		model.addAttribute("ret", ret);
		
		System.out.println("companyInfo="+footerVO.getCompInfo());
		
		// update 후 결과받기

		return "companyInfoUpdate";
		
	}
	
	//관리자-푸터 이용 약관 및 환불규정 /manager/footer/terms 
	@RequestMapping(value = "/manager/footer/tems", method = {RequestMethod.GET,RequestMethod.POST})
	public String temsUpdate(Model model, @ModelAttribute FooterVO footerVO) {

		int ret = managerService.temsUpdateSerivce(footerVO);
		model.addAttribute("ret", ret);
		// update 후 결과받기

		return "temsUpdate";
		

	}
	
	
	//관리자-개인정보 처리방침 /manager/footer/privacy
	@RequestMapping(value = "/manager/footer/privacy", method = {RequestMethod.GET,RequestMethod.POST})
	public String privacyUpdate(Model model, @ModelAttribute FooterVO footerVO) {

		int ret = managerService.privacyUpdateSerivce(footerVO);
		model.addAttribute("ret", ret);
		// update 후 결과받기

		return "privacyUpdate";
		

	}
	
}
