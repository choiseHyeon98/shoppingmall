package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.ProductVO;

@Repository
public class EventDAO {
	@Autowired
	SqlSession session;

	public List<EventVO> selectEvents() {
		// TODO Auto-generated method stub
		
		List<EventVO> EventVO;
		EventVO = session.selectList("mapper.event.eventAllList");
		//이벤트 리스트 전부 담아서 가져옴
		return EventVO;
	}

	public EventVO selectOneEvents(int eventNum) {
		// TODO Auto-generated method stub
		
		EventVO eventVO = session.selectOne("mapper.event.eventOne",eventNum);
		//이벤트 리스트 번호 조회해서 가져옴
		
		return eventVO;
	}

}
