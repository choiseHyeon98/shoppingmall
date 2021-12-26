package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.MemberVO;

@Repository
public class MemberDAO {
	//DAO
	@Autowired
	SqlSession sqlSession;

	public MemberVO isExisted(MemberVO memberVO) {
		// TODO Auto-generated method stub
		System.out.println("memberDAO="+memberVO.toString());
		memberVO = sqlSession.selectOne("mapper.member.isExisted", memberVO);
		return memberVO;
	}
	

	public int addMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int ret = sqlSession.insert("mapper.member.addMember", memberVO);
		return ret;
	}

	// 아이디 중복체크
	public int idCheck(MemberVO memberVO) {
		int ret1 = sqlSession.selectOne("mapper.member.idCheck", memberVO);
		return ret1;
	}

	
	public MemberVO viewId(MemberVO memberVO) {
		// TODO Auto-generated method stub
		System.out.println("memberVO3="+memberVO.toString());
		memberVO = sqlSession.selectOne("mapper.member.viewId", memberVO);
		// System.out.println("memberVO4="+memberVO.toString());

		return memberVO;
	}
	
	// board 내 문의 찾기
	public MemberVO selectName(String id) {
		// TODO Auto-generated method stub
		MemberVO memberVO = sqlSession.selectOne("mapper.member.selectName", id);
		return memberVO;
	}

	public MemberVO selectMyPw(String id) {
		// TODO Auto-generated method stub
		MemberVO memberVO = sqlSession.selectOne("mapper.member.selectExPw", id);
		return memberVO;
	}


	public int updateNewPW(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int ret = sqlSession.update("mapper.member.updatePw", memberVO);
		System.out.println("pwSubmit3="+memberVO.toString());

		return ret;
	}





	
	
	
	
}
