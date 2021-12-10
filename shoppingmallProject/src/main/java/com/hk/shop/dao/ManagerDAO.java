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


	public EventVO eventModDao(EventVO eventNum) {
		// TODO Auto-generated method stub
		return null;
	}


	public int eventModDoneDao(EventVO eventVO) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int productAddDoneDao(ProductVO productVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
