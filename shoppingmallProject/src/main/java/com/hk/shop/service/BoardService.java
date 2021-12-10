package com.hk.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.BoardDAO;
import com.hk.shop.vo.FAQVO;

@Service
public class BoardService {

	@Autowired
	BoardDAO boardDAO;
	public List<FAQVO> allList() {
		// TODO Auto-generated method stub
		return boardDAO.allList();
	}
	public List<FAQVO> ViewOne(int fAQNum) {
		// TODO Auto-generated method stub
		return boardDAO.ViewOne(fAQNum);
	}

}
