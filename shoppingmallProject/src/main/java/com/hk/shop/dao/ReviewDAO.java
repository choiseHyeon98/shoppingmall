package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.ReviewVO;

@Repository
public class ReviewDAO {
	
	@Autowired
	SqlSession session;

	public List<ReviewVO> reivewListDao() {
		// TODO Auto-generated method stub
		
		List<ReviewVO> list = session.selectList("mapper.review.reivewList");
		
		return list;
	}
	
	

}
