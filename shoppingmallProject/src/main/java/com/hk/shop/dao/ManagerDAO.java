package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ProductVO;
import com.hk.shop.vo.ReviewVO;


@Repository
public class ManagerDAO {

	@Autowired
	SqlSession session;

	public List<FooterVO> selectFooterList() {
		// TODO Auto-generated method stub
		return null;
	}


	public int insertEventAdd(EventVO eventVO) {
		// TODO Auto-generated method stub
		
		int ret = session.insert("mapper.event.insertEvent", eventVO); 
		
		return ret;
	}


	public int eventModDoneDao(EventVO eventVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.event.updateEvent",eventVO);
		
		return ret;
	}
	
	public int eventDelDao(int eventNum) {
		// TODO Auto-generated method stub
		
		int ret = session.delete("mapper.event.delEvent", eventNum);
		
		return ret;
	}

	public int productAddDoneDao(ProductVO productVO) {
		// TODO Auto-generated method stub
		return 0;
		//int  ret = session.insert("mapper.product.insertPro",productVO)
	}


	public int deleteProduct(int proNum) {
		// TODO Auto-generated method stub
		return 0;
		//int ret = session.delete("mapper.product.delProduct",proNum)
	}


	public int reviewDelDao(int reviewNum) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.review.delReview", reviewNum);
		
		return ret;
	}


	public int reviewCommentDoneDao(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.review.updateReview",reviewVO);
		
		return ret;
	}


	public int orderCancleDAO(int orderNum) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.orderList.cancleOrder",orderNum);
		
		return ret;
	}


	public int orderUpdateDAO(OrderListVO orderVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.orderList.updateOrder",orderVO);
		
		return ret;
	}


	

}
