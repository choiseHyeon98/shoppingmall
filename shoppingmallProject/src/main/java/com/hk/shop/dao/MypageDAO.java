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
		MemberVO memberVO = sqlSession.selectList("mapper.mypage.selectMyInfo", id);
		return memberVO;
	}


	public int updateMyInfo(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int ret = sqlSession.update("mapper.mypage.updateMyInfo", memberVO);
		System.out.println("infoUpdate3="+memberVO.toString());
		
		return ret;
	}


	public List<CartVO> showMyCart(String id) {
		// TODO Auto-generated method stub
		List <CartVO> cartList = sqlSession.selectList("mapper.mypage.showMyCart", id);
		System.out.println("cart2="+id.toString());
		System.out.println("cartList2="+cartList.toString());

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


	public int deleteCart(int cartNum) {
		// TODO Auto-generated method stub
		System.out.println("cartNum3="+cartNum);
		sqlSession.delete("mapper.mypage.deleteCart", cartNum);
		return 0;
	}


}
