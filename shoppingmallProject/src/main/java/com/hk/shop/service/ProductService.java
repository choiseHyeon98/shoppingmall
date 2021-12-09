package com.hk.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.ProductDAO;
import com.hk.shop.vo.OptionVO;
import com.hk.shop.vo.ProductVO;

@Service
public class ProductService {

	@Autowired
	
	//홈페이지 상품구성
	ProductDAO productDAO;
	public List<ProductVO> selectBest() {
		// TODO Auto-generated method stub
		return productDAO.selectBest();
	}
	public List<ProductVO> selectNew() {
		// TODO Auto-generated method stub
		return productDAO.selectNew();
	}
	public List<ProductVO> selectDaily() {
		// TODO Auto-generated method stub
		return productDAO.selectDaily();
	}
	public List<ProductVO> selectRandom() {
		// TODO Auto-generated method stub
		return productDAO.selectRandom();
	}
	
	//카테고리 리스트별 
	public List<ProductVO> selectAll() {
		// TODO Auto-generated method stub
		return productDAO.selectAll();
	}
	public List<ProductVO> selectCasual() {
		// TODO Auto-generated method stub
		return productDAO.selectCasual();
	}
	public List<ProductVO> selectOffice() {
		// TODO Auto-generated method stub
		return productDAO.selectOffice();
	}
	public List<ProductVO> selectFeminine() {
		// TODO Auto-generated method stub
		return productDAO.selectFeminine();
	}
	public List<ProductVO> selectHip() {
		// TODO Auto-generated method stub
		return productDAO.selectHip();
	}
	public List<ProductVO> selectVintage() {
		// TODO Auto-generated method stub
		return productDAO.selectVintage();
	}
	public List<ProductVO> selectOne(int proNum) {
		// TODO Auto-generated method stub
		//상품 하나만 보기
		return productDAO.selectOne(proNum);
	}
	public List<OptionVO> selectOption(int proNum) {
		// TODO Auto-generated method stub
		//상품 옵션 가져오기
		return productDAO.selectOption(proNum);
	}
	public List<ProductVO> selectProd(OptionVO optionVO) {
		// TODO Auto-generated method stub
		//상품 주문정보 가져와야함!
		return productDAO.selectProd(optionVO);
	}

	
}
