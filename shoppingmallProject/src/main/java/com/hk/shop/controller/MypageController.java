package com.hk.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.hk.shop.service.MypageService;
import com.hk.shop.vo.CartVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ProductVO;
import com.hk.shop.vo.ReviewVO;


@Controller
public class MypageController {
	
	@Autowired
	MypageService mypageService;

	
	@RequestMapping (value="/s/mypage", method=RequestMethod.GET)
	public String ViewMyPage () {
		return "mypageView";
	}


	// 내정보 수정창
	@RequestMapping (value="s/mypage/update", method=RequestMethod.GET)
	public String MypageUpdate(Model model, HttpSession session) {
		//String id = "";
		MemberVO memberVO = (MemberVO) session.getAttribute("login");
		String id = memberVO.getId();
		System.out.println("id="+id);
		
		//Map<String, Object> map = mypageService.viewMyInfo(id);
		List<MemberVO> membeR = mypageService.viewMyInfo(id);
		System.out.println("membeR="+membeR);
		model.addAttribute("membeR", membeR);
		//model.addAttribute("member", map.get("memberVO"));
		return "viewMyInfo";
	}
	
	// 내 정보 수정입력
		@RequestMapping (value="s/mypage/update", method=RequestMethod.POST)
		public String MypageUpdateDone(Model model, @ModelAttribute MemberVO memberVO) {
			System.out.println("infoUpdate0="+memberVO.toString());

			int ret = mypageService.updateMypage(memberVO);
			System.out.println("infoUpdate1="+memberVO.toString());
			model.addAttribute("ret", ret);
			return "mypageUpdateDone";
		}	

	
	@RequestMapping (value="/s/mypage/cart", method=RequestMethod.GET)
	// 濡쒓렇�씤 �븯怨� POST濡� 諛붽� �삁�젙
	public String Cart (Model model, HttpSession session) {
		
		MemberVO memberVO = (MemberVO) session.getAttribute("login");
		String id= memberVO.getId();
			//이 아이디로 카트 정보 가져오기.
		System.out.println("CartId="+id);
		List<CartVO> cartList = mypageService.myCartList(id);
		System.out.println("cartList="+cartList);
		
	//	List<ProductVO> productList = mypageService.findProduct(cartList);
		model.addAttribute("cartList", cartList);
		System.out.println("cartList3="+cartList.toString());
		
		return "cartList"; // �옣諛붽뎄�땲+李쒕ぉ濡� 李�
	}
	
	
	@RequestMapping (value="/s/mypage/myorders", method= {RequestMethod.GET, RequestMethod.POST})
	// 濡쒓렇�씤 �븯怨� POST濡� 諛붽� �삁�젙
	public String MyOrders (Model model, HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("login");
		String id = memberVO.getId();
		System.out.println("MyorderId="+id);
		
		List<OrderListVO> myOrders = mypageService.myOrderList(id);
		System.out.println("myOrders="+myOrders);
		
		model.addAttribute("myOrders", myOrders);
		System.out.println("myOrders="+myOrders.toString());

		return "myorders"; // �궡 二쇰Ц湲곕줉李�
	}
	
	@RequestMapping (value="/delete", method=RequestMethod.GET)
	public String cartDelete (Model model, @RequestParam("cartNum") int cartNum) {
		int ret = mypageService.removeCart(cartNum);
		model.addAttribute("ret", ret);
		return "cartDeleteDone";
	}
	
	@RequestMapping (value="/s/mypage/muldelete", method=RequestMethod.GET)
	public String cartMulDelete (Model model, @RequestParam("chkbox") List<Integer> cartNums) {
		System.out.println("cartNums="+cartNums.toString());
		Map<String, Integer> map = mypageService.cartMultiDelete(cartNums);
		// 그 결과를 model에 넣고 jsp를 전달하라는데..?
		model.addAttribute("cart", map.get("cartVO"));
		
		System.out.println("성공한 갯수="+map.get("succ"));
		System.out.println("실패한 갯수="+map.get("fail"));
		return "cartMulDelete";
	}
	
	
	@RequestMapping (value="s/mypage/addReview", method= RequestMethod.GET)
	public String addReview (Model model, HttpSession session, @RequestParam("proNum") int proNum , @ModelAttribute ReviewVO reviewVO) {
		// 세션 아이디랑 proNum 불러오기
		// , @ModelAttribute ReviewVO reviewVO ??
		MemberVO memberVO = (MemberVO) session.getAttribute("login");
		String id = memberVO.getId();
		System.out.println("id="+id);
		System.out.println("proNum="+proNum);
		//Map <String, Object> map = mypageService.getOrderInfo4Review(id);
		model.addAttribute("review", reviewVO);
		return "addReview"; // 由щ럭 �옉�꽦李� + 二쇰Ц湲곕줉�뿉�꽌留� �뱾�뼱媛꾨떎
	}
	
	
	
	@RequestMapping (value="/s/mypage/addReview", method= RequestMethod.POST)
	// URL �뿰寃고븳 �썑�뿉 POST濡� 怨좎튇�떎
	public String addReviewDone (Model model, @ModelAttribute ReviewVO reviewVO) throws IOException {
		
		
		String fileName = null;
		MultipartFile uploadFile = reviewVO.getUploadReviewImage();
		
		if(uploadFile==null) {
			int ret = mypageService.insertReview(reviewVO);
			System.out.println("reviewVO 수정" + reviewVO.toString());

			model.addAttribute("ret", ret);

			return "addReviewDone";
		}
		
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);

			UUID uuid = UUID.randomUUID();
			fileName = uuid + "." + ext;
			uploadFile.transferTo(new File("c:\\board\\reviewPhoto\\" + fileName));

		}
		reviewVO.setReviewPhoto(fileName);
				
		int ret = mypageService.insertReview(reviewVO);
		System.out.println("newReiview="+reviewVO.toString());

		
		model.addAttribute("ret", ret);
		return "addReviewDone"; // 由щ럭 �옉�꽦李� + 二쇰Ц湲곕줉�뿉�꽌留� �뱾�뼱媛꾨떎
	}
	
	//method= {RequestMethod.GET,RequestMethod.POST}
	
	
}
