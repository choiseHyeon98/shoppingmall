package com.hk.shop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.ProductVO;


@Repository
public class ManagerDAO {

	

	public List<FooterVO> selectFooterList() {
		// TODO Auto-generated method stub
		return null;
	}


	public int insertEventAdd(EventVO eventVO) {
		// TODO Auto-generated method stub
		return 0;
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
