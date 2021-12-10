package com.hk.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.MemberDAO;

@Service
public class MemberService {
	//Service
	
	@Autowired
	MemberDAO memberDAO;
	
	
}
