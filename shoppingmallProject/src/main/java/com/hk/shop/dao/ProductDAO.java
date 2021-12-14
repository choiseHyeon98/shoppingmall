package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.OptionVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ProductVO;
import com.hk.shop.vo.SerchVO;

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
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectAll");
		return productVO;
	}

	public List<ProductVO> selectCasual() {
		// TODO Auto-generated method stub
		//캐주얼 상품 선택
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectCasual");
		return productVO;
	}

	public List<ProductVO> selectOffice() {
		// TODO Auto-generated method stub
		//오피스 상품 선택
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectOffice");
		return productVO;
	}

	public List<ProductVO> selectFeminine() {
		// TODO Auto-generated method stub
		//페미닌 룩
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectFeminine");
		return productVO;
	}

	public List<ProductVO> selectHip() {
		// TODO Auto-generated method stub
		//힙 룩
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectHip");
		return productVO;
	}

	public List<ProductVO> selectVintage() {
		// TODO Auto-generated method stub
		//빈티지 선택
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectVintage");
		return productVO;
	}
	
	//상품 상세보기

	public List<ProductVO> selectOne(int proNum) {
		// TODO Auto-generated method stub
		//상품 상세보기
		//상품 하나만 선택해서 view//옵션도 join해서 같이 가져옴(productVO 에 옵션컬럼도 추가해둠...
		
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectOneView",proNum);
		return productVO;
	}


	//주문상세
	public List<ProductVO> selectProd(ProductVO optionVO) {
		// TODO Auto-generated method stub
		//상품상세에서 주문상세
		//옵션에서 proNum만 받아서 상품 선택...
		List<ProductVO> productVO;
		int proNum = optionVO.getProNum();
		productVO = session.selectList("mapper.product.selectProductViewOption",proNum);
		//SELECT * FROM PRODUCT WHERE "proNum" = #{proNum}
		return productVO;
	}

	public List<ProductVO> selectProd(int cartNum) {
		// TODO Auto-generated method stub
		//찜목록에서 주문상세
		List<ProductVO> productVO;
		productVO = session.selectList("mapper.product.selectProductViewOptionForCart",cartNum);
		/*
		 * SELECT * FROM PRODUCT p ,CART c WHERE "cartNum"=#{cartNum} AND p."proNum" =(SELECT
		 * "proNum" FROM CART WHERE "cartNum"=#{cartNum})
		 */
		return productVO;
	}

	public int OrderDone(OrderListVO orderListVO) {
		// TODO Auto-generated method stub
		int ret = session.insert("mapper.product.insertOrderList",orderListVO);
		return ret;
	}

	public List<ProductVO> serchPro(SerchVO serchVO) {
		// TODO Auto-generated method stub
		List<ProductVO> productVO;
		System.out.println("DAO serchVO: "+serchVO.toString());
		productVO = session.selectList("mapper.product.selectSerchPro",serchVO);
		System.out.println("DAO productVO: "+productVO.toString());
		return productVO;
	}


}
