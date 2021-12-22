package com.hk.shop.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	/*
	@RequestMapping (value="/mypage", method = RequestMethod.GET)
	String mypageHome() {
		
		// Get�쑝濡� �젒�냽�븯硫� 鍮꾨�踰덊샇 �씤利앹갹 �쑝濡� �뿰寃�
		// �꽦怨듯븯硫� �궡 �젙蹂� 蹂댁뿬二쇨퀬
		// �떎�뙣�븯硫� �떎�떆 �씤利앹갹
		
		// 李� 紐⑸줉
		// 二쇰Ц �궡�뿭 議고쉶
		// 由щ럭 �옉�꽦李� 
		
		return ""; // 鍮꾨쾲 �씤利앹갹
	}
	*/
	
	// �궡 �젙蹂� 議고쉶
	// �꽭�뀡 �꽔湲�
	@RequestMapping (value="/s/myinfo", method=RequestMethod.GET)
	// 濡쒓렇�씤 �븯怨� POST濡� 諛붽� �삁�젙
	public String Mypageinfo ( Model model, HttpSession session) {
		String id = "";
		MemberVO memberVO = (MemberVO) session.getAttribute("login");
		id = memberVO.getId();
		Map<String, Object> map = mypageService.viewMyInfo(id);
		model.addAttribute("member", map.get("memberVO"));
		// 세션뺴고 디비가기. 모델써서 login.id를 memberVO.id로 바꾸기
		
		return "mypageInfo"; //--> �씠寃� �옒 �굹�삤�뒗吏�
		
	}


	// 내정보 수정창
	@RequestMapping (value="s/mypage/update", method=RequestMethod.GET)
	public String MypageUpdate(Model model, @RequestParam("id") String id) {
		Map<String, Object> map = mypageService.viewMyInfo(id);
		
		model.addAttribute("member", map.get("memberVO"));
		return "mypageInfo";
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
	
	@RequestMapping (value="s/mypage/addReview", method=RequestMethod.GET)
	public String addReview () {
		return "addReview"; // 由щ럭 �옉�꽦李� + 二쇰Ц湲곕줉�뿉�꽌留� �뱾�뼱媛꾨떎
	}
	
	
	
	@RequestMapping (value="/s/mypage/addReview", method= RequestMethod.POST)
	// URL �뿰寃고븳 �썑�뿉 POST濡� 怨좎튇�떎
	public String addReviewDone (Model model, @ModelAttribute ReviewVO reviewVO) {
		int ret = mypageService.insertReview(reviewVO);
		model.addAttribute("ret", ret);
		return "addReviewDone"; // 由щ럭 �옉�꽦李� + 二쇰Ц湲곕줉�뿉�꽌留� �뱾�뼱媛꾨떎
	}
	
	//method= {RequestMethod.GET,RequestMethod.POST}
	
}
