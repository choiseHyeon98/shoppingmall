package com.hk.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hk.shop.service.ManagerService;
import com.hk.shop.service.ProductService;
import com.hk.shop.vo.AskVO;
import com.hk.shop.vo.CartVO;
import com.hk.shop.vo.EventVO;

import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.ManagerVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OptionVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ProductVO;

import com.hk.shop.vo.ReviewVO;
import com.hk.shop.vo.SerchVO;

@Controller
public class ManagerController {
	/*
	 * 관리자모드 홈페이지 /manager/managerHome 관리자모드 카테고리별 상세리스트 /manager/category
	 * 관리자모드이벤트등록 /manager/eventAdd 관리자 모드 이벤트 수정 /manager/eventMod 관리자 모드 이벤트 삭제
	 * /manager/eventDel 관리자 상품 등록 /manager/product/add 관리자 리뷰 관리
	 * /manager/review/list 관리자 리뷰 댓글 /manager/review/comment 관리자 회원 관리리스트
	 * /manager/member/list 관리자 회원 삭제 /manager/member/del 관리자 회원 관리 적용
	 * /manager/member/update 관리자 주문 관리 /manager/order/list 관ㄹ자 주문 취소
	 * /manager/order/cancel 관리자 문의 관리 /manager/FAQ/list 관리자 문의 댓글
	 * /manager/FAQ/comment 관리자 문의 댓글 삭제 /manager/FAQ/del 관리자 -푸터 회사정보 수정
	 * /manager/footer/companyInfo 관리자-푸터 이용 약관 및 환불규정 /manager/footer/terms
	 * 관리자-개인정보 처리방침 /manager/footer/privacy
	 */
	@Autowired
	ManagerService managerService;
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/manager/managerHome", method = { RequestMethod.GET, RequestMethod.POST })
	public String managerHome(Model model,HttpSession session) {
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
		System.out.println("newList=" + newList.toString());

		// 오늘배송상품 받아오기
		List<ProductVO> todayList = new ArrayList<ProductVO>();
		todayList = managerService.todayService();
		System.out.println("todayList=" + todayList.toString());

		// 전체상품 리스트 받아오기
		List<ProductVO> allList = new ArrayList<ProductVO>();
		allList = managerService.allService();
		System.out.println("allList=" + allList.toString());

		// 푸터받아오기
		List<FooterVO> footerList = new ArrayList<FooterVO>();
		footerList = managerService.footerService();
		
		System.out.println("proudct!!!!!"+ bestList);
		model.addAttribute("eventList", eventList);
		model.addAttribute("bestList", bestList);
		model.addAttribute("newList", newList);
		model.addAttribute("todayList", todayList);
		model.addAttribute("allList", allList);
		model.addAttribute("footerList", footerList);

		// jsp로연결
		return "managerHome";

	}

	// 게시물 검색
	@RequestMapping(value = "/manager/product/serch", method = { RequestMethod.GET, RequestMethod.POST })
	String serch(Model model, @ModelAttribute SerchVO serchVO) {

		String serch = serchVO.getSerch();

		serchVO.setSerch("%" + serchVO.getSerch() + "%");
		System.out.println(serchVO.getSerch());

		List<ProductVO> product;
		product = productService.serchPro(serchVO);
		System.out.println(product.toString());
		model.addAttribute("Product", product);
		model.addAttribute("serch", serch);
		String link;
		if (product.toString() == "[]") {
			link = "manager/serchFail";
		} else {
			link = "manager/serchDone";
		}

		return link;
	}

	// 게시글 삭제 체크박스,
	@RequestMapping(value = "/manager/muldelete", method = RequestMethod.GET)
	public String proMuldelete(Model model, @RequestParam("chkbox") List<Integer> productNums) {
		System.out.println("productNums=" + productNums.toString());
		// articleNOs를 Service에 전달해서 service에서 for문을 통해 삭제
		// 그 결과를 model에 넣고 전달
		// articleNOs=[15,14,13,12,11,10,9]
		Map<String, Integer> map = managerService.mulSerivcle(productNums);
		System.out.println("성공한갯수=" + map.get("succ"));
		System.out.println("실패한갯수=" + map.get("fail"));
		model.addAttribute("map", map);
		return "proMuldelete";

	}

	// 품절처리 체크박스
	@RequestMapping(value = "/manager/mulSoldout", method = RequestMethod.GET)
	public String proSoldout(Model model, @RequestParam("chkbox") List<Integer> productNums) {
		System.out.println("productNums=" + productNums.toString());
		// articleNOs를 Service에 전달해서 service에서 for문을 통해 삭제
		// 그 결과를 model에 넣고 전달
		// articleNOs=[15,14,13,12,11,10,9]
		Map<String, Integer> map = managerService.soldoutService(productNums);
		System.out.println("성공한갯수=" + map.get("succ"));
		System.out.println("실패한갯수=" + map.get("fail"));
		model.addAttribute("map", map);
		return "proSoldout";

	}

	// 카테고리별 상세리스트
	// 1.전체상품
	@RequestMapping(value = "/manager/product/listAll", method = { RequestMethod.GET, RequestMethod.POST })
	String allCategory(Model model) {
		List<ProductVO> Product = productService.selectAll();
		model.addAttribute("Product", Product);
		System.out.println("AllList" + Product.toString());
		return "manager/ProductList";
	}

	// 2. 캐주얼 상품
	@RequestMapping(value = "/manager/product/listCasual", method = { RequestMethod.GET, RequestMethod.POST })
	String casualCategory(Model model) {
		List<ProductVO> Product = productService.selectCasual();
		model.addAttribute("Product", Product);
		System.out.println("listCasual" + Product.toString());
		return "manager/ProductList";
	}

	// 3. 오피스 상품/product/listOffice
	@RequestMapping(value = "/manager/product/listOffice", method = { RequestMethod.GET, RequestMethod.POST })
	String officeCategory(Model model) {
		List<ProductVO> Product = productService.selectOffice();
		model.addAttribute("Product", Product);
		System.out.println("listOffice" + Product.toString());
		return "manager/ProductList";
	}

	// 4. 페미닌 상품/product/listFeminine
	@RequestMapping(value = "/manager/product/listFeminine", method = { RequestMethod.GET, RequestMethod.POST })
	String feminineCategory(Model model) {
		List<ProductVO> Product = productService.selectFeminine();
		model.addAttribute("Product", Product);
		System.out.println("listFeminine" + Product.toString());
		return "manager/ProductList";
	}

	// 5. 힙 상품/product/listHip
	@RequestMapping(value = "/manager/product/listHip", method = { RequestMethod.GET, RequestMethod.POST })
	String hipCategory(Model model) {
		List<ProductVO> Product = productService.selectHip();
		model.addAttribute("Product", Product);
		System.out.println("listHip" + Product.toString());
		return "manager/ProductList";
	}

	// 6. 빈티지 상품/product/listVintage
	@RequestMapping(value = "/manager/product/listVintage", method = { RequestMethod.GET, RequestMethod.POST })
	String vintageCategory(Model model) {
		List<ProductVO> Product = productService.selectVintage();
		model.addAttribute("Product", Product);
		System.out.println("listVintage" + Product.toString());
		return "manager/ProductList";
	}

	// 오늘배송
	@RequestMapping(value = "/manager/product/listDaily", method = { RequestMethod.GET, RequestMethod.POST })
	String dailyCategory(Model model) {
		List<ProductVO> Product = productService.selectDaily();
		model.addAttribute("Product", Product);
		return "manager/ProductList";
	}

	// 상품상세보기
	// 상품상세//view뿐....
	// form action으로 주문하기 url로 연결(post방식으로 전달)
	@RequestMapping(value = "/manager/product/detail", method = { RequestMethod.GET, RequestMethod.POST })
	String detailView(Model model, @RequestParam("proNum") int proNum) {
		List<ProductVO> Product = productService.selectOne(proNum);
		List<ReviewVO> review = productService.selectReview(proNum);
		model.addAttribute("Product", Product);
		model.addAttribute("review", review);
		System.out.println("상품상세보기" + Product.toString());
		System.out.println("review" + review.toString());

		String link;
		if (Product.toString() != "[]") {
			link = "/manager/ProductView";
		} else {
			// 요청하신 상품을 찾을 수 없습니다 로 보냄.
		}
		return "/manager/ProductView";
	}

	// event배너 추가 폼
	@RequestMapping(value = "/manager/event/add", method = RequestMethod.GET)
	public String eventAdd() {

		return "eventAdd";

	}

	// event배너 추가 완료
	@RequestMapping(value = "/manager/event/add", method = RequestMethod.POST)
	public String eventAddDone(Model model, @ModelAttribute EventVO eventVO) throws IOException {

		String fileName = null;
		MultipartFile uploadFile = eventVO.getUploadEventImage();
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);

			UUID uuid = UUID.randomUUID();
			fileName = uuid + "." + ext;
			uploadFile.transferTo(new File("c:\\board\\eventImg\\" + fileName));

		}
		eventVO.setEventImg(fileName);

		int ret = managerService.eventAddDoneService(eventVO);
		System.out.println("eventVO " + eventVO.toString());
		model.addAttribute("ret", ret);

		return "eventAddDone";
		// 등록이 완료되었습니다 .jsp alert

	}

	// event배너 수정 폼
	@RequestMapping(value = "/manager/event/mod", method = RequestMethod.GET)
	public String eventMod(Model model, @ModelAttribute EventVO eventVO) {

		EventVO event = managerService.eventModService(eventVO);

		System.out.println("eventVO=" + eventVO);
		model.addAttribute("event", event);

		return "eventMod";

	}

	
	  // event배너 파일삭제
	  
	  @RequestMapping(value = "/manager/event/fileDel", method = RequestMethod.POST) 
	  public String eventFileDel(Model model, @ModelAttribute EventVO eventVO,MultipartFile file) {
			/*
			 * System.out.println("originalFile="+file); if(!file.isEmpty()) { //String
			 * fileName = file.getOriginalFilename();
			 */
	  
	  if(!eventVO.getEventImg().isEmpty() || eventVO.getEventImg()!= null) { 
		  File fileDel = new File("c:\\board\\eventImg\\"+eventVO.getEventImg()); 
		  if (fileDel.exists()) {
			  fileDel.delete(); 
			  System.out.println("기존이미지삭제"); 
			  } 
		  }
	  
	  int ret = managerService.fileDelete(eventVO);
	  model.addAttribute("ret", ret);
	  System.out.println("del:"+ret);
	  
	  return "redirect:mod?eventNum="+eventVO.getEventNum();
	  
	  }
	 
	// event배너 수정 완료
	@RequestMapping(value = "/manager/event/mod", method = RequestMethod.POST)
	public String eventModDone(Model model, @ModelAttribute EventVO eventVO, MultipartFile file)throws IOException {
		
		String fileName = null;
		MultipartFile uploadFile = eventVO.getUploadEventImage();;
				
		if(uploadFile==null) {
			int ret = managerService.eventModDoneService(eventVO);
			System.out.println("eventVO 수정" + eventVO.toString());

			model.addAttribute("ret", ret);

			return "eventModDone";
		}
		
		
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);

			UUID uuid = UUID.randomUUID();
			fileName = uuid + "." + ext;
			uploadFile.transferTo(new File("c:\\board\\eventImg\\" + fileName));

			eventVO.setEventImg(fileName);
		
		
		
		}
		int ret = managerService.eventModDoneService(eventVO);
		System.out.println("eventVO 수정" + eventVO.toString());

		model.addAttribute("ret", ret);

		return "eventModDone";
			
		// 이벤트 폼이 수정되었습니다 alert
	}

	// event 배너 삭제
	@RequestMapping(value = "/manager/event/del", method = RequestMethod.POST)
	public String eventDel(Model model, @RequestParam("eventNum") int eventNum) {
		
		
		int ret = managerService.eventDelService(eventNum);
		model.addAttribute("ret", ret);

		return "redirect:/manager/managerHome";
	}

	// 관리자 상품 등록 폼으로 가는 URL
	@RequestMapping(value = "/manager/product/add", method = RequestMethod.GET)
	public String productAdd(Model model) {

		return "productAdd";

	}

	// 관리자 상품 등록 완료
	@RequestMapping(value = "/manager/product/add", method = RequestMethod.POST)
	public String productAddDone(Model model, @ModelAttribute ProductVO productVO,@RequestParam("sizeOption")List<Object> sizeOption, @RequestParam("colorOption")List<Object> colorOption ) throws IOException {
		
		
		
		System.out.println("저장실행");
		System.out.println("값 ==="+colorOption); 
		System.out.println("값 ==="+sizeOption);
		
		int i=0;
		List<OptionVO> OptionList = new ArrayList<OptionVO>();
		for(Object color: colorOption) {
			OptionVO option = new OptionVO();
			
			option.setColorOption((String)color);
		
			option.setSizeOption((String)sizeOption.get(i));
			OptionList.add(option);
			i++;
		}
		System.out.println("리스트값 ==="+OptionList.toString());
		
		
		String fileName = null;
		  MultipartFile uploadFile = productVO.getUploadFileTop();
		  if (!uploadFile.isEmpty()) { 
			  String originalFileName =uploadFile.getOriginalFilename(); 
			  String ext = FilenameUtils.getExtension(originalFileName);
		  
		  UUID uuid = UUID.randomUUID(); fileName = uuid + "." + ext;
		  uploadFile.transferTo(new File("c:\\board\\productImg\\productImg" + fileName));
		  
		  } 
		  productVO.setTopImage(fileName);
		                             
		  String fileDetail = null;
		  MultipartFile uploadFileDetail = productVO.getUploadFileDetail();
		  if (!uploadFileDetail.isEmpty()) { 
			  String originalFileName =uploadFileDetail.getOriginalFilename(); 
			  String ext = FilenameUtils.getExtension(originalFileName);
		  
		  UUID uuid = UUID.randomUUID(); fileDetail = uuid + "." + ext;
		  uploadFileDetail.transferTo(new File("\\board\\productImg\\detailsImg" + fileDetail));
		  
		  } 
		  productVO.setDetailsImg(fileDetail);
		  
		 
		  System.out.println("optionList!!!!!!!!!!!!!!!!!!!"+OptionList);
		  
		  int ret = managerService.productAddDoneService(productVO,OptionList);
		 
		  model.addAttribute("ret", ret);
		  System.out.println("ret="+ret);
		  System.out.println("prductVo=" + productVO.toString());
		 
		return "productAddDone";
	} // 추가가 완료되었습니다 alert

	// 상품 등록 수정 페이지
	// 상품 삭제
	
	
	
	// 관리자 리뷰 리스트
	@RequestMapping(value = "/manager/review/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String reviewList(Model model) {

		List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		reviewList = managerService.reviewListService();

		System.out.println("reviewList=" + reviewList.toString());

		model.addAttribute("reviewList", reviewList);

		return "reviewList";
	}

	// 관리자 리뷰 댓글 작성 폼이동 /manager/reviewComment
	@RequestMapping(value = "/manager/review/comment", method = RequestMethod.GET)
	public String reviewComment(Model model, @RequestParam("reviewNum") int reviewNum) {

		ReviewVO reviewVO = managerService.reviewCommentSerivce(reviewNum);
		System.out.println("comment=" + reviewVO.toString());
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
	@RequestMapping(value = "/manager/review/del", method = { RequestMethod.GET, RequestMethod.POST })
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

		System.out.println("memberList=" + memberList.toString());

		return "management";
		// 회원목록
	}

	// 관리자 회원 삭제 /manager/memberDel
	@RequestMapping(value = "/manager/member/del", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberDel(Model model, @RequestParam("id") String id) {
		System.out.println("id="+ id);
		int ret = managerService.memberDelService(id);
		model.addAttribute("ret", ret);

		System.out.println("memberDel=" + ret);
		
		return "redirect:list";
		// 회원정보가 삭제되었습니다 alert .jsp
	}

	// 관리자 회원 관리 적용 /manager/memberUpdate
	@RequestMapping(value = "/manager/member/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberUpdate(Model model, @ModelAttribute MemberVO memberVO ) {
		// 등급설정, 블랙리스트 체크박스 정보 업데이트
		
		
		/*
		 * List<OrderListVO> orderList = new ArrayList<OrderListVO>(); for(Object
		 * ranking: rank) { OptionVO option = new OptionVO();
		 * 
		 * option.setColorOption((String)color);
		 * 
		 * option.setSizeOption((String)sizeOption.get(i)); OptionList.add(option); i++;
		 * }
		 */
		
		System.out.println("MemberVO!!!!!!!!!!!!"+memberVO);
		int ret = managerService.memberUpdateService(memberVO);
		model.addAttribute("ret", ret);

		System.out.println("memberUpdate=" + ret);

		return "redirect:list";
	}
	// 관리자 주문 관리 /manager/order/list

	@RequestMapping(value = "/manager/order/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberOrderList(Model model) {
		
		
		List<OrderListVO> orderList = new ArrayList<OrderListVO>();
		
		orderList = managerService.memberOrderListService();
		
		
		System.out.println("orderList=" + orderList.toString());
		model.addAttribute("orderList", orderList);

		return "memberOrderList";
	}

	// lists -> VO 1ro,, VO 2
	//

	// 관리자 주문 한개 주문 선택 /manager/order/cancel

	// 관ㄹ자 주문 취소 /manager/order/cancel

	@RequestMapping(value = "/manager/order/cancle", method = { RequestMethod.GET, RequestMethod.POST })
	public String orderCancel(Model model, @RequestParam("orderNum") int orderNum) {

		int ret = managerService.memberOrderCancleService(orderNum);
		System.out.println("orderNum=" + orderNum);
		model.addAttribute("ret", ret);

		// update로 주문상태 환불로 변경 하시겠습니까?
		return "redirect:list";
	}

	// 관리자 주문관리 변경 저장 /manager/order/update
	// 수정해야됨
	// orderNum하고 delStatus하고 한방에 가져와야됨
	@RequestMapping(value = "/manager/order/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String orderUpdate(Model model ,@ModelAttribute OrderListVO orderVO  ) {

		int ret = managerService.memberOrderUpdateService(orderVO);
		
		System.out.println("orderupdate!!!!!!!!!" + orderVO.toString());
		model.addAttribute("ret", ret);
		System.out.println("memberOrderList=" + ret);

		return "redirect:list";
	}

	// 관리자 문의 관리 목록 /manager/ask/list
	@RequestMapping(value = "/manager/ask/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String askList(Model model) {

		List<AskVO> askList = new ArrayList<AskVO>();
		askList = managerService.askListService();

		model.addAttribute("askList", askList);
		System.out.println("askList=" + askList.toString());

		return "askList";
	}

	// 관리자 문의 댓글 폼이동 /manager/ask/comment->update 셀렉트
	@RequestMapping(value = "/manager/ask/comment", method = RequestMethod.GET)
	public String askSelectOne(Model model, @RequestParam("askNum") int askNum) {

		AskVO askVO = managerService.askSelectOneSerivce(askNum);
		model.addAttribute("askVO", askVO);
		System.out.println("askVO=" + askVO.toString());
		// update 후 결과받기

		return "askComment";
		// 답글작성이 완료되었습니다 alert -> reviewList

	}

	// 관리자 문의 댓글 /manager/FAQ/comment->update
	@RequestMapping(value = "/manager/ask/comment", method = RequestMethod.POST)
	public String askComment(Model model, @ModelAttribute AskVO askVO) {

		int ret = managerService.askCommentSerivce(askVO);
		model.addAttribute("ret", ret);
		// update 후 결과받기
		System.out.println("askVO!!!!!!!!!!!!!!!!!!!"+ ret);
		System.out.println("askVO=" + askVO.toString());
		return "redirect:list";
		// 답글작성이 완료되었습니다 alert -> reviewList

	}

	// 관리자 -푸터 회사정보 수정 /manager/footer/companyInfo
	@RequestMapping(value = "/manager/footer/companyInfo", method = RequestMethod.GET)
	public String companyInfo(Model model, @ModelAttribute("compInfo") String compInfo) {

		FooterVO footerVO = managerService.companyInfoService(compInfo);
		model.addAttribute("footerVO", footerVO);

		return "companyInfoUpdate";

	}

	// 관리자 -푸터 회사정보 수정 /manager/footer/companyInfo
	@RequestMapping(value = "/manager/footer/companyInfo", method = RequestMethod.POST)
	public String companyInfoUpdate(Model model, @ModelAttribute FooterVO footerVO) {

		int ret = managerService.companyInfoUpdateSerivce(footerVO);
		model.addAttribute("ret", ret);

		System.out.println("companyInfo=" + footerVO.getCompInfo());

		// update 후 결과받기

		return "companyInfoUpdateDone";

	}

	// 관리자-푸터 이용 약관 및 환불규정 /manager/footer/terms
	@RequestMapping(value = "/manager/footer/tems", method = RequestMethod.GET)
	public String temsUpdate(Model model, @ModelAttribute("tems") String tems) {

		FooterVO footerVO = managerService.temsUpdateFormSerivce(tems);
		model.addAttribute("footerVO", footerVO);

		return "temsUpdate";

	}

	// 관리자-푸터 이용 약관 및 환불규정 /manager/footer/terms
	@RequestMapping(value = "/manager/footer/tems", method = RequestMethod.POST)
	public String temsUpdate(Model model, @ModelAttribute FooterVO footerVO) {

		int ret = managerService.temsUpdateSerivce(footerVO);
		model.addAttribute("ret", ret);
		// update 후 결과받기

		return "temsUpdateDone";

	}

	// 관리자-푸터 이용 약관 및 환불규정 /manager/footer/terms
	@RequestMapping(value = "/manager/footer/privacy", method = RequestMethod.GET)
	public String privacyUpdate(Model model, @ModelAttribute("privacy") String privacy) {

		FooterVO footerVO = managerService.privacyUpdateFormSerivce(privacy);
		model.addAttribute("footerVO", footerVO);

		return "privacyUpdate";

	}

	// 관리자-개인정보 처리방침 /manager/footer/privacy
	@RequestMapping(value = "/manager/footer/privacy", method = RequestMethod.POST)
	public String privacyUpdateDone(Model model, @ModelAttribute FooterVO footerVO) {

		int ret = managerService.privacyUpdateSerivce(footerVO);
		model.addAttribute("ret", ret);
		// update 후 결과받기

		return "privacyUpdateDone";

	}
	//관리자 로그인
	@RequestMapping(value = "/manager/login", method = RequestMethod.GET)
	public String Login() {
		// Session 설정
		return "managerlogin"; // 로그인하는 창
	}

	// 로그인
		@RequestMapping(value = "/manager/login", method = RequestMethod.POST)
		public String LoginDone(@ModelAttribute ManagerVO managerVO ,HttpSession session) {
			// 사용자가 입력한 값을 불러와서
			// 실패했을때는 실패했다고 알려주고 다시 로그인창
			System.out.println("managerVO=" + managerVO.toString());
			managerVO = managerService.isExisted(managerVO);

			String retUrl = "loginDone"; // 로그인 성공이면 완료창

			if (managerVO == null) {
				// id/pw가 틀림

				retUrl = "loginFail";
				// return "redirect:/login"
			} else {
				// id/pw가 맞음
				// Session 설정
				session.setAttribute("adminlogin", managerVO);
			
				
				return "redirect:/manager/managerHome";
			}
			return retUrl;
		}
}
