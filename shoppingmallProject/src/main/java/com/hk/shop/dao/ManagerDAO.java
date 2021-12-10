package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.ProductVO;


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


	

}
