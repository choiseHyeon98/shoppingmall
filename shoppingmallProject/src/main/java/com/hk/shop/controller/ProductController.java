package com.hk.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.shop.service.ProductService;
import com.hk.shop.vo.CartVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ProductVO;
import com.hk.shop.vo.ReviewVO;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	HttpSession session;

	// 카테고리 리스트 페이지...
	// 1. 전체상품
	@RequestMapping(value = "/product/listAll", method = { RequestMethod.GET, RequestMethod.POST })
	String allCategory(Model model) {
		List<ProductVO> Product = productService.selectAll();
		String name = "전체";
		model.addAttribute("Name", name);
		model.addAttribute("Product", Product);
		System.out.println("AllList" + Product.toString());
		return "ProductList";
	}

	// 2. 캐주얼 상품
	@RequestMapping(value = "/product/listCasual", method = { RequestMethod.GET, RequestMethod.POST })
	String casualCategory(Model model) {
		List<ProductVO> Product = productService.selectCasual();
		model.addAttribute("Product", Product);
		String name = "캐주얼";
		model.addAttribute("Name", name);
		System.out.println("listCasual" + Product.toString());
		return "ProductList";
	}

	// 3. 오피스 상품/product/listOffice
	@RequestMapping(value = "/product/listOffice", method = { RequestMethod.GET, RequestMethod.POST })
	String officeCategory(Model model) {
		List<ProductVO> Product = productService.selectOffice();
		model.addAttribute("Product", Product);
		String name = "오피스";
		model.addAttribute("Name", name);
		System.out.println("listOffice" + Product.toString());
		return "ProductList";
	}

	// 4. 페미닌 상품/product/listFeminine
	@RequestMapping(value = "/product/listFeminine", method = { RequestMethod.GET, RequestMethod.POST })
	String feminineCategory(Model model) {
		List<ProductVO> Product = productService.selectFeminine();
		model.addAttribute("Product", Product);
		String name = "페미닌";
		model.addAttribute("Name", name);
		System.out.println("listFeminine" + Product.toString());
		return "ProductList";
	}

	// 5. 힙 상품/product/listHip
	@RequestMapping(value = "/product/listHip", method = { RequestMethod.GET, RequestMethod.POST })
	String hipCategory(Model model) {
		List<ProductVO> Product = productService.selectHip();
		model.addAttribute("Product", Product);
		String name = "힙";
		model.addAttribute("Name", name);
		System.out.println("listHip" + Product.toString());
		return "ProductList";
	}

	// 6. 빈티지 상품/product/listVintage
	@RequestMapping(value = "/product/listVintage", method = { RequestMethod.GET, RequestMethod.POST })
	String vintageCategory(Model model) {
		List<ProductVO> Product = productService.selectVintage();
		model.addAttribute("Product", Product);
		String name = "빈티지";
		model.addAttribute("Name", name);
		System.out.println("listVintage" + Product.toString());
		return "ProductList";
	}

	// 오늘배송
	@RequestMapping(value = "/product/listDaily", method = { RequestMethod.GET, RequestMethod.POST })
	String dailyCategory(Model model) {
		List<ProductVO> Product = productService.selectDaily();
		model.addAttribute("Product", Product);
		String name = "오늘배송";
		model.addAttribute("Name", name);
		System.out.println("listDaily"+Product);
		return "ProductList";
	}

	// 상품상세//view뿐....
	@RequestMapping(value = "/product/detail", method = { RequestMethod.GET, RequestMethod.POST })
	String detailView(Model model, @RequestParam("proNum") int proNum) {
		List<ProductVO> Product = productService.selectOne(proNum);
		List<ReviewVO> review = productService.selectReview(proNum);
		model.addAttribute("Product", Product);
		model.addAttribute("review", review);
		System.out.println("상품상세보기" + Product.toString());
		System.out.println("review" + review.toString());
		
		String link;
		if(Product.toString()!="[]") {
			link="ProductView";
		} else {
			link="warning";
		}
		return link;
	}

	@RequestMapping(value = "/s/product/orderList", method =RequestMethod.POST)
	String orderProduct(Model model, @ModelAttribute ProductVO productOption) {
		System.out.println(productOption.toString());
		ProductVO Product = productService.selectProd(productOption);
		productOption.setPrice(productOption.getPrice()*productOption.getCountProNum());
		// 상품 정보 담아오기...
		System.out.println("상품Product" + Product.toString());
		System.out.println("상품Option" + productOption.toString());
        MemberVO memberVO = (MemberVO) session.getAttribute("login");
        System.out.println("memberVO controllerprocon:"+memberVO);
        model.addAttribute("memberVO", memberVO);
		model.addAttribute("Product", Product);
		model.addAttribute("productOption", productOption);
		return "ProductOrder";
	}
	
	//찜목록에 추가하기
	@RequestMapping(value = "/s/mypage/addCartList", method = RequestMethod.POST)
	String orderCartProduct(Model model, @ModelAttribute CartVO cartVO) {
		System.out.println("cartVO: "+cartVO);
		cartVO.setPrice(cartVO.getPrice()*cartVO.getCountProNum());
		System.out.println("cartVO: "+cartVO);
		//id받아와서 cart에 추가
		MemberVO memberVO = (MemberVO) session.getAttribute("login");
		cartVO.setId(memberVO.getId());
		System.out.println(cartVO);
		int ret = productService.addCart(cartVO);
		System.out.println("ret: "+ret);
		 int proNum = cartVO.getProNum();
		model.addAttribute("ret",ret);
		model.addAttribute("proNum",proNum);
		return "cartAddDone";
	}
	/*
	 * // 찜목록에서 주문하기!-삭제된 기능입니다.
	 * 
	 * @RequestMapping(value = "/s/mypage/orderList", method = { RequestMethod.GET,
	 * RequestMethod.POST }) // test를 위해 일단 get도 열어둠/ test이후 post만 남길것. String
	 * orderCartProduct(Model model, @RequestParam("cartNum") int cartNum) { //
	 * List<ProductVO> Product = productService.selectProd(cartNum);
	 * model.addAttribute("Product", Product); System.out.println("찜Product 상세보기" +
	 * Product.toString()); return "ProductOrderC"; }
	 */

	// 주문완료
	@RequestMapping(value="/s/product/orderDone", method=RequestMethod.POST)
	String orderDone(Model model , @ModelAttribute OrderListVO orderListVO) {
		//주문정보 받아야함...
		//상품번호, 주문자 id, 사이즈옵션, 컬러옵션, 주문금액, 운송장 번호, 결제방법, 상품 주문 수량
		int orderDone = productService.OrderDone(orderListVO);
		System.out.println(orderDone);
		model.addAttribute("orderDone", orderDone);
		//orderDone이 1이면 성공, 0이면 실패
		return "orderDone";
	}

}
