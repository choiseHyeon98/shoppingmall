package com.hk.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.MemberVO;

@Repository
public class MypageDAO {

	@Autowired
	SqlSession sqlSession;
	
	public List<MemberVO> showMyInfo() {
		// TODO Auto-generated method stub
		List <MemberVO> mypageinfo = sqlSession.selectList("mapper.mypage.showMyInfo");
		return mypageinfo;
	}

}
