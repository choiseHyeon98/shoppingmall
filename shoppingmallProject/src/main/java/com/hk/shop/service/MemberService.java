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
	
	// 중복체크 (코드)
	public String duplicateCheck(String id) {
		// TODO Auto-generated method stub
		return memberDAO.duplicateCheckId(id);
	}
	
	// 중복체크 (책)
	public String overlapped(String id) {
		// TODO Auto-generated method stub
		return memberDAO.duplicateCheckId(id);
	}



	public int addMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return memberDAO.addMember(memberVO);
	}


	public MemberVO findId(MemberVO memberVO) {
		// TODO Auto-generated method stub
		System.out.println("memberVO2="+memberVO.toString());

		return memberDAO.viewId(memberVO);

	}

	public int updatePw(MemberVO memberVO) {
		// TODO Auto-generated method stub
		System.out.println("pwSubmit2="+memberVO.toString());

		return memberDAO.updateNewPW(memberVO);
	}



	
	
	
}
