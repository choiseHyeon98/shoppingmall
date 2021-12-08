package com.hk.shop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.ProductVO;

@Repository
public class EventDAO {

	public List<EventVO> selectEvents() {
		// TODO Auto-generated method stub
		
		List<EventVO> EventVO;
		//EventVO = session.selectList("mapper.board.selectAllArticleList");
		//이벤트 리스트 전부 담아서 가져옴
		return null;
	}

	public List<EventVO> selectOneEvents() {
		// TODO Auto-generated method stub
		List<EventVO> EventVO;
		//EventVO = session.selectList("mapper.board.selectAllArticleList");
		//이벤트 리스트 번호 조회해서 가져옴
		
		return null;
	}

}
