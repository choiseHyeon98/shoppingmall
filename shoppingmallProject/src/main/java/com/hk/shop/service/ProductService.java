package com.hk.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.ProductDAO;
import com.hk.shop.vo.ProductVO;

@Service
public class ProductService {

	@Autowired
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



}
