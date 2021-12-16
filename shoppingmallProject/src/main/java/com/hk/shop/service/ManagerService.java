package com.hk.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.BoardDAO;
import com.hk.shop.dao.EventDAO;
import com.hk.shop.dao.ManagerDAO;
import com.hk.shop.dao.MemberDAO;
import com.hk.shop.dao.OrderListDAO;
import com.hk.shop.dao.ProductDAO;
import com.hk.shop.dao.ReviewDAO;
import com.hk.shop.vo.AskVO;
import com.hk.shop.vo.EventVO;

import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OrderListVO;
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
	@Autowired
	ReviewDAO reviewDAO;
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	OrderListDAO orderListDAO;
	@Autowired
	BoardDAO boardDAO;
	
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
	
	public int eventDelService(int eventNum) {
		// TODO Auto-generated method stub
		return managerDAO.eventDelDao(eventNum);
	}

	public int productAddDoneService(ProductVO productVO) {
		
		// TODO Auto-generated method stub
		return managerDAO.productAddDoneDao(productVO);
	}

	public List<ProductVO> listDailyService() {
		// TODO Auto-generated method stub
		return productDAO.selectDaily();
	}

	public List<ProductVO> listAllService() {
		// TODO Auto-generated method stub
		return productDAO.selectAll();
	}

	public List<ReviewVO> reviewListService() {
		// TODO Auto-generated method stub
		return reviewDAO.reivewListDao();
	}

	public ReviewVO reviewCommentSerivce(int reviewNum) {
		// TODO Auto-generated method stub
		return reviewDAO.selectReview(reviewNum);
	}
	
	public int reviewCommentDoneSerivce(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		return managerDAO.reviewCommentDoneDao(reviewVO);
	}
	public int reviewDelService(int reviewNum) {
		// TODO Auto-generated method stub
		return managerDAO.reviewDelDao(reviewNum);
	}

	public List<MemberVO> memberListService() {
		// TODO Auto-generated method stub
		//member 등급도 받아야함
		//블랙리스트 체크 박스도 받아야함
		
		return managerDAO.memberListDAO();
	}

	public int memberDelService(String id) {
		// TODO Auto-generated method stub
		return managerDAO.memberDelDAO(id);
	}

	
	public int memberUpdateService(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return managerDAO.memberUpdateDAO(memberVO);
	}

	public List<OrderListVO> memberOrderListService() {
		// TODO Auto-generated method stub
		return orderListDAO.selectAllList();
	}

	public int memberOrderCancleService(int orderNum) {
		// TODO Auto-generated method stub
		
		return managerDAO.orderCancleDAO(orderNum);
	}

	public int memberOrderUpdateService(OrderListVO orderVO) {
		// TODO Auto-generated method stub
		return managerDAO.orderUpdateDAO(orderVO);
	}

	public List<AskVO> askListService() {
		// TODO Auto-generated method stub
		return managerDAO.askListDAO();
	}
	public AskVO askSelectOneSerivce(int askNum) {
		// TODO Auto-generated method stub
		return managerDAO.askSelectDAO(askNum);
	}
	public int askCommentSerivce(AskVO askVO) {
		// TODO Auto-generated method stub
		return managerDAO.askCommentDAO(askVO);
	}


	public int companyInfoUpdateSerivce(FooterVO footerVO) {
		// TODO Auto-generated method stub
		return managerDAO.footerInfoDAO(footerVO);
	}

	public int temsUpdateSerivce(FooterVO footerVO) {
		// TODO Auto-generated method stub
		return managerDAO.footerTemsDAO(footerVO);
	}

	public int privacyUpdateSerivce(FooterVO footerVO) {
		// TODO Auto-generated method stub
		return managerDAO.footerprivacyDAO(footerVO);
	}

	public Map<String, Integer> mulSerivcle(List<Integer> productNums) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new HashMap<String,Integer>();
		int succ=0, fail=0;
		
		for(int i=0; i<productNums.size(); i++) {
			//지울번호 한개 꺼내서
			int proNum = productNums.get(i);
			int ret = managerDAO.deleteProduct(proNum);
			//ret=0이면 실패,ret !=0이면 성공
			
			if(ret!=0) {
				//성공이면
				++succ;
			} else {
				//실패이면
				++fail;
			}
		}
		//성공갯수,실패갯수
		map.put("succ", succ);
		map.put("fail", fail);
		return map;
		//2번째 성공한 번호, 실패한번호
		//map["success"] = ArrayList<>;
		//map["fail"] = ArrayLsit<>;
		
	}

	public Map<String, Integer> soldoutSerivcle(List<Integer> productNums) {
		// TODO Auto-generated method stub
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		int succ=0, fail=0;
		
		for(int i=0; i<productNums.size(); i++) {
			//지울번호 한개 꺼내서
			int proNum = productNums.get(i);
			int ret = managerDAO.soldoutPro(proNum);
			//ret=0이면 실패,ret !=0이면 성공
			
			if(ret!=0) {
				//성공이면
				++succ;
			} else {
				//실패이면
				++fail;
			}
		}
		//성공갯수,실패갯수
		map.put("succ", succ);
		map.put("fail", fail);
		
		return map;
	}

	

	

	

}
