package com.hk.shop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hk.shop.vo.FooterVO;

@Controller
public class FooterDAO {
	
	@Autowired
	SqlSession session;
	public FooterVO selectAll() {
		// TODO Auto-generated method stub
		FooterVO list = session.selectOne("mapper.footer.selectAll");

		return list;
	}


}
