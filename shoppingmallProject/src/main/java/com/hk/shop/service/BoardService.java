package com.hk.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.BoardDAO;
import com.hk.shop.dao.MemberDAO;
import com.hk.shop.vo.AskVO;
import com.hk.shop.vo.FAQVO;
import com.hk.shop.vo.MemberVO;

@Service
public class BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	@Autowired
	MemberDAO memberDAO;
	
	public List<FAQVO> allList() {
		// TODO Auto-generated method stub
		return boardDAO.allList();
	}
	public FAQVO ViewOne(int fAQNum) {
		// TODO Auto-generated method stub
		return boardDAO.ViewOne(fAQNum);
	}
	
	public List<AskVO> myQuestions(String id) {
		// TODO Auto-generated method stub
		return boardDAO.myQuestions(id);
	}
	
	public int insertMyAsk(AskVO askVO) {
		// TODO Auto-generated method stub
		return boardDAO.insertMyAsk(askVO);
	}
	
	public AskVO viewMyAsk(int askNum) {
		// TODO Auto-generated method stub
		//AskVO askVO = boardDAO.selectMyAsk(askNum);
		//MemberVO memberVO = memberDAO.selectName(askVO.getId());
		//MemberVO memberVO = MemberDAO.selectName(memberVO.getId());
		
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("askVO", askVO);
		//map.put("memberVO", memberVO);
		return boardDAO.selectMyAsk(askNum);
	}
	
	public int modifyAsk(AskVO askVO) {
		// TODO Auto-generated method stub
		return boardDAO.updateMyAsk(askVO);
	}
	
	
	
	public List<FAQVO> FAQOrder() {
		// TODO Auto-generated method stub1
		return boardDAO.FAQOrder();
	}
	public List<FAQVO> FAQDel() {
		// TODO Auto-generated method stub2
		return boardDAO.FAQDel();
	}
	public List<FAQVO> FAQCenOrd() {
		// TODO Auto-generated method stub3
		return boardDAO.FAQCenOrd();
	}
	public List<FAQVO> FAQRe() {
		// TODO Auto-generated method stub4
		return boardDAO.FAQRe();
	}
	public List<FAQVO> FAQPro() {
		// TODO Auto-generated method stub5
		return boardDAO.FAQPro();
	}
	public List<FAQVO> FAQMem() {
		// TODO Auto-generated method stub6
		return boardDAO.FAQMem();
	}



}
