package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.EventVO;
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

	public ReviewVO selectReview(int reviewNum) {
		// TODO Auto-generated method stub
		 
		ReviewVO reivewVO = session.selectOne("mapper.review.reviewOne",reviewNum);
		
		return reivewVO;
	}
	

	public List<ReviewVO> selectReviewForPro(int proNum) {
		// TODO Auto-generated method stub
		List<ReviewVO> reivewVO = session.selectList("mapper.review.selectReviewForPro",proNum);
		return reivewVO;
	}
	

}
