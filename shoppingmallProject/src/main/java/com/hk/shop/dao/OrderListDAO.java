package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.DeliveryVO;
import com.hk.shop.vo.OrderListVO;

@Repository
public class OrderListDAO {

	@Autowired
	SqlSession session;

	public List<OrderListVO> selectAllList() {
		// TODO Auto-generated method stub
		List<OrderListVO> list = session.selectList("mapper.orderList.selectAllorder");
			
		return list;
	}

	public int newOrder(OrderListVO orderList) {
		// TODO Auto-generated method stub
		int ret = session.insert("mapper.orderList.newOrder", orderList);
		return ret;
	}

	public int newDel(DeliveryVO delVo) {
		// TODO Auto-generated method stub
		int ret = session.insert("mapper.orderList.newDel", delVo);
		return ret;
	}
		
		

	
}
