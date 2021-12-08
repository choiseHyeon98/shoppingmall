package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.ProductVO;

@Repository
public class ProductDAO {
	
	@Autowired
	SqlSession session;

	public List<ProductVO> selectBest() {
		// TODO Auto-generated method stub
		//여기서 베스트 상품을 선택하는 쿼리를 mapper를 통해 작성받고 리턴하기
		List<ProductVO> productVO;
		//productVO = session.selectList("mapper.board.selectAllArticleList");
		//잘나가는 상품 주문리스트에서 상품번호로 카운트, 카운트가 많은 순서대로 정렬, 3번째에서 자르기
		return null;
	}

	public List<ProductVO> selectNew() {
		// TODO Auto-generated method stub
		List<ProductVO> productVO;
		//productVO = session.selectList("mapper.board.selectAllArticleList");
		//등록된 상품 순서대로 조회, 새로운 상품 순서로 자르기
		return null;
	}

	public List<ProductVO> selectDaily() {
		// TODO Auto-generated method stub
		List<ProductVO> productVO;
		//productVO = session.selectList("mapper.board.selectAllArticleList");
		//오늘 배송 상품 조회		
		return null;
	}

	public List<ProductVO> selectRandom() {
		// TODO Auto-generated method stub
		List<ProductVO> productVO;
		//productVO = session.selectList("mapper.board.selectAllArticleList");
		//상품 랜덤하게 섞어서 담기
		return null;
	}

}
