package com.hk.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hk.shop.dao.MemberDAO;
import com.hk.shop.dao.MypageDAO;
import com.hk.shop.dao.ProductDAO;
import com.hk.shop.vo.CartVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ProductVO;
import com.hk.shop.vo.ReviewVO;

@Service
public class MypageService {

	@Autowired
	MypageDAO mypageDAO;
	
	@Autowired
	MemberDAO memberDAO;
	
	@Autowired
	ProductDAO productDAO;


	public Map<String, Object> viewMyInfo(String id) {
		// TODO Auto-generated method stub
		
		MemberVO memberVO = mypageDAO.selectMyinfo(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberVO", memberVO);
		return map;
	}


	public int updateMypage(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return mypageDAO.updateMyInfo(memberVO);
	
	}


	public List<CartVO> myCartList(String id) {
		// TODO Auto-generated method stub
		return mypageDAO.showMyCart(id);
	}

	public List<ProductVO> findProduct(List<CartVO> cartList) {
		// TODO Auto-generated method stub
		return productDAO.findMyProduct(cartList);
	}


	public List<OrderListVO> myOrderList(String id) {
		// TODO Auto-generated method stub
		return mypageDAO.showMyOrderList(id);
	}

	public int insertReview(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		return mypageDAO.insertMyReview(reviewVO);
	}





	

	
	
	
	
}
