package com.hk.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.FooterDAO;
import com.hk.shop.vo.FooterVO;

@Service
public class FooterService {
	
	@Autowired
	FooterDAO footerDAO;

	public FooterVO selectAll() {
		// TODO Auto-generated method stub
		return footerDAO.selectAll();
	}

	



}
