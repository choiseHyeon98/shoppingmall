package com.hk.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hk.shop.dao.MemberDAO;
import com.hk.shop.dao.MypageDAO;
import com.hk.shop.vo.CartVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ReviewVO;

@Service
public class MypageService {

	@Autowired
	MypageDAO mypageDAO;
	
	@Autowired
	MemberDAO memberDAO;


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


	public List<CartVO> myCartList() {
		// TODO Auto-generated method stub
		return mypageDAO.showMyCart();
	}

	public List<OrderListVO> myOrderList() {
		// TODO Auto-generated method stub
		return mypageDAO.showMyOrderList();
	}

	public int insertReview(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		return mypageDAO.insertMyReview(reviewVO);
	}



	

	
	
	
	
}
