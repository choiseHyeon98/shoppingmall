package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.OptionVO;
import com.hk.shop.vo.ProductVO;

@Repository
public class ProductDAO {
	
	@Autowired
	SqlSession session;

	public List<ProductVO> selectBest() {
		// TODO Auto-generated method stub
		//여기서 베스트 상품을 선택하는 쿼리를 mapper를 통해 작성받고 리턴하기
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectBest");
		//잘나가는 상품 주문리스트에서 상품번호로 카운트, 카운트가 많은 순서대로 정렬, 3번째에서 자르기
		return productVO;
	}

	public List<ProductVO> selectNew() {
		// TODO Auto-generated method stub
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectNew");
		//productVO = session.selectList("mapper.board.selectAllArticleList");
		//등록된 상품 순서대로 조회, 새로운 상품 순서로 자르기
		return productVO;
	}

	public List<ProductVO> selectDaily() {
		// TODO Auto-generated method stub
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectDaily");
		//오늘 배송 상품 조회		
		return productVO;
	}

	public List<ProductVO> selectRandom() {
		// TODO Auto-generated method stub
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectRandom");
		//productVO = session.selectList("mapper.board.selectAllArticleList");
		//상품 랜덤하게 섞어서 담기
		return productVO;
	}

	//상품 카테고리
	public List<ProductVO> selectAll() {
		// TODO Auto-generated method stub
		//상품 전체선택
		//SELECT * FROM PRODUCT
		return null;
	}

	public List<ProductVO> selectCasual() {
		// TODO Auto-generated method stub
		//캐주얼 상품 선택
		//SELECT * FROM PRODUCT WHERE "proCon" = 'Casual'
		return null;
	}

	public List<ProductVO> selectOffice() {
		// TODO Auto-generated method stub
		//오피스 상품 선택
		return null;
		//SELECT * FROM PRODUCT WHERE "proCon" = 'Office'
	}

	public List<ProductVO> selectFeminine() {
		// TODO Auto-generated method stub
		//페미닌 룩
		//SELECT * FROM PRODUCT WHERE "proCon" = 'Feminine'
		return null;
	}

	public List<ProductVO> selectHip() {
		// TODO Auto-generated method stub
		//힙 룩
		//SELECT * FROM PRODUCT WHERE "proCon" = 'Hip'
		return null;
	}

	public List<ProductVO> selectVintage() {
		// TODO Auto-generated method stub
		//빈티지 선택
		//SELECT * FROM PRODUCT WHERE "proCon" = 'Vintage'
		return null;
	}

	public List<ProductVO> selectOne(int proNum) {
		// TODO Auto-generated method stub
		//상품 상세보기
		//상품 하나만 선택해서 view
		//SELECT * FROM PRODUCT WHERE "proNum" = '#{}'
		return null;
	}

	public List<OptionVO> selectOption(int proNum) {
		// TODO Auto-generated method stub
		//상품 하나만 선택해서 상품 옵션 가져오기...
		return null;
	}

	public List<ProductVO> selectProd(OptionVO optionVO) {
		// TODO Auto-generated method stub
		//옵션에서 proNum만 받아서 상품 선택...
		//SELECT * FROM PRODUCT WHERE "proNum" = #{proNum}
		return null;
	}

}
