package com.hk.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.ManagerDAO;
import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.ProductVO;

@Service
public class ManagerService {

	@Autowired
	ManagerDAO managerDAO;
	
	public List<EventVO> eventService() {
		// TODO Auto-generated method stub
		return managerDAO.selectEventList();
	}

	public List<ProductVO> bestService() {
		// TODO Auto-generated method stub
		return managerDAO.selectBestList();
	}

	public List<ProductVO> newService() {
		// TODO Auto-generated method stub
		return managerDAO.selectNewList();
	}

	public List<ProductVO> todayService() {
		// TODO Auto-generated method stub
		return managerDAO.selectTodayList();
	}

	public List<ProductVO> allService() {
		// TODO Auto-generated method stub
		return managerDAO.selectAllList();
	}

	public List<FooterVO> footerService() {
		// TODO Auto-generated method stub
		return managerDAO.selectFooterList();
	}

	public int eventAddDoneService(EventVO eventVO) {
		
		// TODO Auto-generated method stub
		return managerDAO.insertEventAdd(eventVO);
	}

}
