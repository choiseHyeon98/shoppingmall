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
import com.hk.shop.vo.ProductVO;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	//카테고리 리스트 페이지...
	// 1. 전체상품 
	@RequestMapping (value="/product/listAll", method= {RequestMethod.GET,RequestMethod.POST})
	String allCategory(Model model) {
		List<ProductVO> Product = productService.selectAll();
		model.addAttribute("Product", Product);
		return "ProductList";
	}
	
	//2. 캐주얼 상품
	@RequestMapping (value="/product/listCasual", method= {RequestMethod.GET,RequestMethod.POST})
	String casualCategory(Model model) {
		List<ProductVO> Product = productService.selectCasual();
		model.addAttribute("Product", Product);
		return "ProductList";
	}
	// 3. 오피스 상품/product/listOffice
	@RequestMapping (value="/product/listOffice", method= {RequestMethod.GET,RequestMethod.POST})
	String officeCategory(Model model) {
		List<ProductVO> Product = productService.selectOffice();
		model.addAttribute("Product", Product);
		return "ProductList";
	}
	
	// 4. 페미닌 상품/product/listFeminine
	@RequestMapping (value="/product/listFeminine", method= {RequestMethod.GET,RequestMethod.POST})
	String feminineCategory(Model model) {
		List<ProductVO> Product = productService.selectFeminine();
		model.addAttribute("Product", Product);
		return "ProductList";
	}
		
		// 5. 힙 상품/product/listHip
	@RequestMapping (value="/product/listHip", method= {RequestMethod.GET,RequestMethod.POST})
	String hipCategory(Model model) {
		List<ProductVO> Product = productService.selectHip();
		model.addAttribute("Product", Product);
		return "ProductList";
	}
	// 6. 빈티지 상품/product/listVintage
	@RequestMapping (value="/product/listVintage", method= {RequestMethod.GET,RequestMethod.POST})
	String vintageCategory(Model model) {
		List<ProductVO> Product = productService.selectVintage();
		model.addAttribute("Product", Product);
		return "ProductList";
	}
	
	//오늘배송
	@RequestMapping (value="/product/listDaily", method= {RequestMethod.GET,RequestMethod.POST})
	String dailyCategory(Model model) {
		List<ProductVO> Product = productService.selectDaily();
		model.addAttribute("Product", Product);
		return "ProductList";
	}
	
	//상품상세//view뿐....
	//form action으로 주문하기 url로 연결(post방식...?)
	@RequestMapping (value="/product/detail", method= {RequestMethod.GET,RequestMethod.POST})
	String detailView(Model model, @RequestParam("proNum") int proNum) {
		List<ProductVO> Product = productService.selectOne(proNum);
		List<OptionVO> option = productService.selectOption(proNum);
		model.addAttribute("Product", Product);
		model.addAttribute("option", option);
		return "ProductView";
	}
	
	
	
	//주문하기
	//form으로 액션... 들어오면 
	
	@RequestMapping (value="/s/product/orderList", method= {RequestMethod.GET,RequestMethod.POST})
	String orderProduct(Model model, @ModelAttribute OptionVO OptionVO) {
		List<ProductVO> Product = productService.selectProd(OptionVO);
		model.addAttribute("Product", Product);
		return "ProductView";
	}
	
	
	//주문취소(취소가 눌리면 alret으로 취소되었습니다. 하고 이전페이지로 돌아가기)
	
	//주문완료


	

}
