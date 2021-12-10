package com.hk.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.shop.service.ProductService;
import com.hk.shop.vo.OptionVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ProductVO;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	// 카테고리 리스트 페이지...
	// 1. 전체상품
	@RequestMapping(value = "/product/listAll", method = { RequestMethod.GET, RequestMethod.POST })
	String allCategory(Model model) {
		List<ProductVO> Product = productService.selectAll();
		model.addAttribute("Product", Product);
		System.out.println("AllList" + Product.toString());
		return "ProductList";
	}

	// 2. 캐주얼 상품
	@RequestMapping(value = "/product/listCasual", method = { RequestMethod.GET, RequestMethod.POST })
	String casualCategory(Model model) {
		List<ProductVO> Product = productService.selectCasual();
		model.addAttribute("Product", Product);
		System.out.println("listCasual" + Product.toString());
		return "ProductList";
	}

	// 3. 오피스 상품/product/listOffice
	@RequestMapping(value = "/product/listOffice", method = { RequestMethod.GET, RequestMethod.POST })
	String officeCategory(Model model) {
		List<ProductVO> Product = productService.selectOffice();
		model.addAttribute("Product", Product);
		System.out.println("listOffice" + Product.toString());
		return "ProductList";
	}

	// 4. 페미닌 상품/product/listFeminine
	@RequestMapping(value = "/product/listFeminine", method = { RequestMethod.GET, RequestMethod.POST })
	String feminineCategory(Model model) {
		List<ProductVO> Product = productService.selectFeminine();
		model.addAttribute("Product", Product);
		System.out.println("listFeminine" + Product.toString());
		return "ProductList";
	}

	// 5. 힙 상품/product/listHip
	@RequestMapping(value = "/product/listHip", method = { RequestMethod.GET, RequestMethod.POST })
	String hipCategory(Model model) {
		List<ProductVO> Product = productService.selectHip();
		model.addAttribute("Product", Product);
		System.out.println("listHip" + Product.toString());
		return "ProductList";
	}

	// 6. 빈티지 상품/product/listVintage
	@RequestMapping(value = "/product/listVintage", method = { RequestMethod.GET, RequestMethod.POST })
	String vintageCategory(Model model) {
		List<ProductVO> Product = productService.selectVintage();
		model.addAttribute("Product", Product);
		System.out.println("listVintage" + Product.toString());
		return "ProductList";
	}

	// 오늘배송
	@RequestMapping(value = "/product/listDaily", method = { RequestMethod.GET, RequestMethod.POST })
	String dailyCategory(Model model) {
		List<ProductVO> Product = productService.selectDaily();
		model.addAttribute("Product", Product);
		System.out.println("listDaily"+Product);
		return "ProductList";
	}

	// 상품상세//view뿐....
	// form action으로 주문하기 url로 연결(post방식으로 전달)
	@RequestMapping(value = "/product/detail", method = { RequestMethod.GET, RequestMethod.POST })
	String detailView(Model model, @RequestParam("proNum") int proNum) {
		List<ProductVO> Product = productService.selectOne(proNum);
		model.addAttribute("Product", Product);
		System.out.println("상품상세보기" + Product.toString());
		return "ProductView";
	}

	// 주문하기
	// form으로 액션... 들어오면
	// 찜목록에서 여러 옵션이 들어오면...?
	// 옵션 수량은 찜목록 수량을 가져오기.
	// 찜목록에서 cartNum받아와서 구현....

	// 상세보기옵션 선택후 그 값을 받아서 VO에 담아서 전달!
	// 받아야할 정보들
	// proNum
	// sizeOption
	// colorOption
	@RequestMapping(value = "/s/product/orderList", method = { RequestMethod.GET, RequestMethod.POST })
	// test를 위해 일단 get도 열어둠/ test이후 post만 남길것.
	String orderProduct(Model model, @ModelAttribute ProductVO productOption) {
		System.out.println(productOption.toString());
		List<ProductVO> Product = productService.selectProd(productOption);
		// 상품 정보 담아오기...
		System.out.println("상품Product 상세보기" + Product.toString());
		System.out.println("상품Option 상세보기" + productOption.toString());
		model.addAttribute("Product", Product);
		model.addAttribute("productOption", productOption);
		return "ProductView";
	}

	// 찜목록에서 주문하기!
	@RequestMapping(value = "/s/mypage/orderList", method = { RequestMethod.GET, RequestMethod.POST })
	// test를 위해 일단 get도 열어둠/ test이후 post만 남길것.
	String orderCartProduct(Model model, @RequestParam("cartNum") int cartNum) {
		//
		List<ProductVO> Product = productService.selectProd(cartNum);
		model.addAttribute("Product", Product);
		System.out.println("찜Product 상세보기" + Product.toString());
		return "ProductView";
	}

	// 주문취소(취소가 눌리면 alret으로 취소되었습니다.홈페이지로 보내기or이전페이지로 보내기)(onClick function으로 jsp에서
	// 처리. 페이지 필요 X)

	// 주문완료
	@RequestMapping(value = "/s/product/orderDone", method = { RequestMethod.GET, RequestMethod.POST })
	// test를 위해 일단 get도 열어둠/ test이후 post만 남길것.
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
