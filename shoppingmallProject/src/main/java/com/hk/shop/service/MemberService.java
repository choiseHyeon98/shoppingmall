package com.hk.shop.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.shop.dao.MemberDAO;
import com.hk.shop.vo.MemberVO;

@Service
public class MemberService {
	//Service
	
	@Autowired
	MemberDAO memberDAO;

	public MemberVO isExisted(MemberVO memberVO) {
		// TODO Auto-generated method stub
		System.out.println("memberService="+memberVO.toString());
		return memberDAO.isExisted(memberVO);
	}

	public int addMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return memberDAO.addMember(memberVO);
	}

	public Map<String, Object> findId(String name) {
		// TODO Auto-generated method stub
		MemberVO memberVO = memberDAO.viewId(name);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("MemberVO", memberVO);
		
		return map;
	}

	
	
	
}
