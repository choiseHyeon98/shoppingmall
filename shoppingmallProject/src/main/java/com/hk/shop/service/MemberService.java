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
	
/*	
	// 아이디 중복체크
	public int idCheck (MemberVO memberVO) {
		return memberDAO.idCheck(memberVO);
	}
*/	

	public MemberVO getItsmeSession(MemberVO memberVO) {
		// TODO Auto-generated method stub
		System.out.println("memberVO2="+memberVO.toString());

		return memberDAO.getItsmeSession(memberVO);

	}
	
	public MemberVO findId(MemberVO memberVO) {
		// TODO Auto-generated method stub
		System.out.println("memberVO2="+memberVO.toString());

		return memberDAO.viewId(memberVO);

	}
	

	public Map<String, Object> getMyPW(String id) {
		// TODO Auto-generated method stub
		MemberVO memberVO = memberDAO.selectMyPw(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberVO", memberVO);
		return map;
	}


	public int updatePw(MemberVO memberVO) {
		// TODO Auto-generated method stub
		System.out.println("pwSubmit2="+memberVO.toString());

		return memberDAO.updateNewPW(memberVO);
	}


	public String duplcateCheck(String id) {
		// TODO Auto-generated method stub
		return memberDAO.duplcateCheck(id);
	}


	
	
	
}
