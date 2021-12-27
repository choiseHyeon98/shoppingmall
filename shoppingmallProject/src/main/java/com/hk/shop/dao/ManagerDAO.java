package com.hk.shop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.shop.vo.AskVO;
import com.hk.shop.vo.EventVO;
import com.hk.shop.vo.FooterVO;
import com.hk.shop.vo.MemberVO;
import com.hk.shop.vo.OptionVO;
import com.hk.shop.vo.OrderListVO;
import com.hk.shop.vo.ProductVO;
import com.hk.shop.vo.ReviewVO;


@Repository
public class ManagerDAO {

	@Autowired
	SqlSession session;

	public List<FooterVO> selectFooterList() {
		// TODO Auto-generated method stub
		return null;
	}


	public int insertEventAdd(EventVO eventVO) {
		// TODO Auto-generated method stub
		
		int ret = session.insert("mapper.event.insertEvent", eventVO); 
		
		return ret;
	}


	public int eventModDoneDao(EventVO eventVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.event.updateEvent",eventVO);
		
		return ret;
	}
	
	public int eventDelDao(int eventNum) {
		// TODO Auto-generated method stub
		
		int ret = session.delete("mapper.event.delEvent", eventNum);
		
		return ret;
	}

	public int productAddDoneDao(ProductVO productVO, List<OptionVO> optionList) {
		// TODO Auto-generated method stub
		int ret =0;
		 int proret = session.insert("mapper.product.insertPro",productVO);
		
		 int optionret = session.insert("mapper.option.insertOption",optionList);
		 
		 if((proret+optionret)>1) {
			ret=1;  
		 } else { 
			ret=0; }
		 
		
		return ret;
		
	}


	public int deleteProduct(int proNum) {
		// TODO Auto-generated method stub
		
		int ret = session.delete("mapper.product.deletePro",proNum);
		
		return ret;
		//int ret = session.delete("mapper.product.delProduct",proNum)
	}


	public int reviewDelDao(int reviewNum) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.review.delReview", reviewNum);
		
		return ret;
	}


	public int reviewCommentDoneDao(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.review.updateReview",reviewVO);
		
		return ret;
	}


	public int orderCancleDAO(int orderNum) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.orderList.cancleOrder",orderNum);
		
		return ret;
	}


	public int orderUpdateDAO(ArrayList<OrderListVO> orderVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.orderList.updateOrder",orderVO);
		
		
		
		return ret;
	}


	public List<MemberVO> memberListDAO() {
		// TODO Auto-generated method stub
		
		List<MemberVO> memberVO = session.selectList("mapper.member.selectAllMember");
		
		return memberVO;
	}


	public int memberDelDAO(String id) {
		// TODO Auto-generated method stub
		
		int ret = session.delete("mapper.member.delMemebr",id);
		
		return ret;
	}


	public int memberUpdateDAO(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.member.updateMember", memberVO);
		
		return ret;
	}


	public int footerInfoDAO(FooterVO footerVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.footer.updateInfo",footerVO);
		System.out.println("ret");
		return ret;
	}


	public int footerTemsDAO(FooterVO footerVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.footer.updateTems",footerVO);
		
		return ret;
	}


	public int footerprivacyDAO(FooterVO footerVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.footer.updatePrivacy",footerVO);
		
		return ret;
	}


	public List<AskVO> askListDAO() {
		// TODO Auto-generated method stub
		
		List<AskVO> askList = session.selectList("mapper.board.selectAllAsk");
		
		return askList;
	}


	public AskVO askSelectDAO(int askNum) {
		// TODO Auto-generated method stub
		
		AskVO askVo = session.selectOne("mapper.board.selectMyAsk", askNum);
		
		return askVo;
	}


	public int askCommentDAO(AskVO askVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.board.updateComment",askVO);
		System.out.println("ask");
		
		return ret;
	}


	public int soldoutPro(int proNum) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.product.soldout",proNum);
		
		return ret;
	}


	public FooterVO companyInfoDAO(String compInfo) {
		// TODO Auto-generated method stub
		
		FooterVO footerVO = session.selectOne("mapper.footer.selectCompInfo", compInfo);
		
		return footerVO;
	}


	public FooterVO temsUpdateFormDAO(String tems) {
		// TODO Auto-generated method stub
		
		FooterVO footerVO = session.selectOne("mapper.footer.selecttems", tems);

		
		return footerVO;
	}


	public FooterVO privacyUpdateFormDAO(String privacy) {
		// TODO Auto-generated method stub
		
		FooterVO footerVO = session.selectOne("mapper.footer.selectprivacy", privacy);
		
		return footerVO;
	}

	public int fileDeleteDAO(EventVO eventVO) {
		// TODO Auto-generated method stub
		
		int ret = session.update("mapper.event.deleteFile",eventVO);
		
		return ret;
	}












	

	

}
