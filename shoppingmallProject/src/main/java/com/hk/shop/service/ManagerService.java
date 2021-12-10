package com.hk.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.EventDAO;
import com.hk.shop.dao.ManagerDAO;
import com.hk.shop.dao.ProductDAO;
import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.ProductVO;

import com.hk.shop.vo.ReviewVO;

@Service
public class ManagerService {

	@Autowired
	ManagerDAO managerDAO;
	@Autowired
	EventDAO eventDAO;
	@Autowired
	ProductDAO productDAO;
	
	public List<EventVO> eventService() {
		// TODO Auto-generated method stub
		return eventDAO.selectEvents();
	}

	public List<ProductVO> bestService() {
		// TODO Auto-generated method stub
		return productDAO.selectBest();
	}

	public List<ProductVO> newService() {
		// TODO Auto-generated method stub
		return productDAO.selectNew();
	}

	public List<ProductVO> todayService() {
		// TODO Auto-generated method stub
		return productDAO.selectBest();
	}

	public List<ProductVO> allService() {
		// TODO Auto-generated method stub
		return productDAO.selectBest();
	}

	public List<FooterVO> footerService() {
		// TODO Auto-generated method stub
		return managerDAO.selectFooterList();
	}

	public int eventAddDoneService(EventVO eventVO) {
		
		// TODO Auto-generated method stub
		return managerDAO.insertEventAdd(eventVO);
	}

	public EventVO eventModService(int eventNum) {
		// TODO Auto-generated method stub
		return eventDAO.selectOneEvents(eventNum);
		
	}

	public int eventModDoneService(EventVO eventVO) {
		
		// TODO Auto-generated method stub
		return managerDAO.eventModDoneDao(eventVO);
	}

	public int productAddDoneService(ProductVO productVO) {
		
		// TODO Auto-generated method stub
		return managerDAO.productAddDoneDao(productVO);
	}

	public List<ProductVO> listDailyService() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductVO> listAllService() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ReviewVO> reviewListService() {
		// TODO Auto-generated method stub
		return null;
	}

	public int reviewCommentSerivce(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<MemberVO> memberListService(MemberVO memberVO) {
		// TODO Auto-generated method stub
		//member 등급도 받아야함
		//블랙리스트 체크 박스도 받아야함
		
		return null;
	}

	public int memberDelService(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int reviewDelService(int reviewNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
