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
	public List<FAQVO> allList() {
		// TODO Auto-generated method stub
		return boardDAO.allList();
	}
	public List<FAQVO> ViewOne(int fAQNum) {
		// TODO Auto-generated method stub
		return boardDAO.ViewOne(fAQNum);
	}
	
	public List<AskVO> myQuestions() {
		// TODO Auto-generated method stub
		return boardDAO.myQuestions();
	}
	
	public Map<String, Object> viewMyAsk(int askNum) {
		// TODO Auto-generated method stub
		AskVO askVO = boardDAO.selectMyAsk(askNum);
		//MemberVO memberVO = MemberDAO.selectName(memberVO.getId());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("askVO", askVO);
		//map.put("memberVO", memberVO);
		return map;
	}
	
	public int modifyAsk(AskVO askVO) {
		// TODO Auto-generated method stub
		return boardDAO.updateMyAsk(askVO);
	}

}
