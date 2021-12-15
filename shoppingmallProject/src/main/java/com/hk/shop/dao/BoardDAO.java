package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.AskVO;
import com.hk.shop.vo.FAQVO;

@Repository
public class BoardDAO {

	@Autowired
	SqlSession session;

	public List<FAQVO> allList() {
		// TODO Auto-generated method stub
		List<FAQVO> FAQList = session.selectList("mapper.board.selectFAQAllList");
		return FAQList;
	}
	
	public List<FAQVO> ViewOne(int FAQNum) {
		// TODO Auto-generated method stub
		List<FAQVO> FAQList = session.selectList("mapper.board.selectFAQOneList", FAQNum);
		return FAQList;
	}

	public List<AskVO> myQuestions(AskVO askVO) {
		// TODO Auto-generated method stub
		List<AskVO> myAskList = session.selectList("mapper.board.selectMyQList", askVO);
		return myAskList;
	}
	
	public int insertMyAsk(AskVO askVO) {
		// TODO Auto-generated method stub
		int ret = session.insert("mapper.board.insertMyAsk", askVO);
		return ret;
	}

	public AskVO selectMyAsk(int askNum) {
		// TODO Auto-generated method stub
		AskVO askVO = session.selectOne("mapper.board.selectMyAsk", askNum);
		return askVO;
	}

	public int updateMyAsk(AskVO askVO) {
		// TODO Auto-generated method stub
		int ret = session.update("mapper.board.updateAsk", askVO);
		return ret;
	}


}
