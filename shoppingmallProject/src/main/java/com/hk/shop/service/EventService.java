package com.hk.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.EventDAO;
import com.hk.shop.vo.EventVO;

@Service
public class EventService {

	@Autowired
	EventDAO eventDAO;
	public List<EventVO> selectEvents() {
		// TODO Auto-generated method stub
		return eventDAO.selectEvents();
	}
	public List<EventVO> selectOneEvents(int eventNum) {
		// TODO Auto-generated method stub
		return eventDAO.selectOneEvents(eventNum);
	}


}
