package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.hk.shop.vo.CartVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ReviewVO;

@Repository
public class MypageDAO {

	@Autowired
	SqlSession sqlSession;
	

	public MemberVO selectMyinfo(String id) {
		// TODO Auto-generated method stub
		MemberVO memberVO = sqlSession.selectOne("mapper.mypage.selectMyInfo", id);
		return memberVO;
	}


	public int updateMyInfo(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int ret = sqlSession.update("mapper.mypage.updateMyInfo", memberVO);
		System.out.println("infoUpdate2="+memberVO.toString());
		return ret;
	}


	public List<CartVO> showMyCart(String id) {
		// TODO Auto-generated method stub
		List <CartVO> cartList = sqlSession.selectList("mapper.mypage.showMyCart", id);
		return cartList;
	}

	public List<OrderListVO> showMyOrderList(String id) {
		// TODO Auto-generated method stub
		List <OrderListVO> myOrders = sqlSession.selectList("mapper.mypage.showMyOrderList", id);
		return myOrders;
	}

	public int insertMyReview(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		int ret = sqlSession.insert("mapper.mypage.insertMyReview");
		return ret;
	}


}
