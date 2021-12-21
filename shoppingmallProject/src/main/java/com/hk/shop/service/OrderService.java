package com.hk.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.OrderListDAO;
import com.hk.shop.vo.DeliveryVO;
import com.hk.shop.vo.OrderListVO;

@Service
public class OrderService {
	
	@Autowired
	OrderListDAO orderdao;

	public int newOrder(OrderListVO orderList) {
		// TODO Auto-generated method stub
		
		return orderdao.newOrder(orderList);
		
	}

	public int newDel(DeliveryVO delVo) {
		// TODO Auto-generated method stub
		
		return orderdao.newDel(delVo);
	}

}
