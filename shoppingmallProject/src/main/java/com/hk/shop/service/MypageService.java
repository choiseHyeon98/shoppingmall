package com.hk.shop.service;

import java.util.ArrayList;
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


	public List<MemberVO> viewMyInfo(String id) {
		// TODO Auto-generated method stub
		/*
		MemberVO memberVO = mypageDAO.selectMyinfo(id);
		System.out.println("id2="+id);

		// Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberVO", memberVO);
		*/
		return mypageDAO.selectMyinfo(id);
	}


	public int updateMypage(MemberVO memberVO) {
		// TODO Auto-generated method stub
		System.out.println("infoUpdate="+memberVO.toString());

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

	public int removeCart(int cartNum) {
		// TODO Auto-generated method stub
		return mypageDAO.deleteCart(cartNum);
	}

	
	// cartMulDel
	public Map<String, Integer> cartMultiDelete(List<Integer> cartNums) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int succ = 0, fail = 0;
		
		for (int i=0; i<cartNums.size(); i++) {
			// 지울 번호 하나 꺼내서
			int cartNum = cartNums.get(i);
			System.out.println("cartNum2="+cartNum);
			int ret = mypageDAO.deleteCart(cartNum);
			// ret = 0이면 실패, ret != 0이면 성공
			if (ret!=0) {
				// 성공이면
				++succ;
			} else {
				// 실패면
				++fail;
			}
		}
		
		// 성공갯수, 실패 갯수
		map.put("succ", succ);
		map.put("fail", fail);
		
		return map;
	}


	




	

	
	
	
	
}
