package com.hk.shop.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.shop.service.MemberService;
import com.hk.shop.vo.MemberVO;

@Controller
public class MemberController {
	//Controller
	
	@Autowired
	MemberService memberService;
	
	/*
	@RequestMapping (value="/", method=RequestMethod.GET)
	public String home () {
		return "home"; // 최초 접속이니까 홈페이지
	}
	*/
	
	
	@RequestMapping (value="/shop/login", method=RequestMethod.GET)
	public String Login () {
		// Session 설정
		return "login"; // 로그인하는 창
	}
	
	// 로그인
	@RequestMapping (value="/shop/login", method=RequestMethod.POST)
	public String LoginDone (@ModelAttribute MemberVO memberVO, HttpSession session) {
		// 사용자가 입력한 값을 불러와서
		// 실패했을때는 실패했다고 알려주고 다시 로그인창
		System.out.println("memberVO1="+memberVO.toString());
		memberVO = memberService.isExisted(memberVO);
		
		String retUrl = "loginDone"; // 로그인 성공이면 완료창
		
		if (memberVO == null) {
			// id/pw가 틀림
			
			retUrl ="loginFail";
			// return "redirect:/login"
		} else {
			// id/pw가 맞음
			// Session 설정
			session.setAttribute("login", memberVO);
			return "loginDone";
		}
		return retUrl;
	}
	
	
	// 로그아웃
	@RequestMapping (value="/shop/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout (HttpSession session, Model model) {
		// 기존의 세션이 있으면 로그아웃
		String name=""; // jsp에서 불러야하니까 model
		if (session != null && session.getAttribute("login") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("login");
			name = memberVO.getName();
		} // session 날리기전에 model에서 name불러 jsp에서 사용
		session.invalidate();
		
		return "logout";
	}
	
	
	@RequestMapping (value="/member/register", method=RequestMethod.GET)
	public String Register () {
		// 회원가입
		return "register"; // 회원가입하는 창
	}
	
	@RequestMapping (value="/member/register", method=RequestMethod.POST)
	public String RegisterDone (Model model, @ModelAttribute MemberVO memberVO) {
		
		System.out.println("id="+memberVO.getId());
		
		int ret = memberService.addMember(memberVO);
		model.addAttribute("ret", ret);
		
		return "registerDone"; // 가입 완료 된 창
	}
	
/*	
	// 내 정보 수정 GET 조회먼저
	// 나중에 세션도 넣어야함
	@RequestMapping (value="/mypage/myinfoUpdate", method=RequestMethod.GET)
	public String MyinfoView (Model model, @RequestParam("id") String id) {
		Map<String, Object> map = memberService.viewMyinfo(id);
		model.addAttribute("member", map.get("memberVO"));
		
		return "mypageInfo";
	}
*/	
	// 내 정보 수정 완 POST
	
	
	
	
	@RequestMapping (value="/member/findIdPw", method=RequestMethod.GET)
	public String FindIdPw () {
		return "findIdPw"; // 아이디/비번찾기 입력창
	}
	
	@RequestMapping (value="/member/findId", method=RequestMethod.POST)
	public String FindId (Model model, @RequestParam("name") String name) {
		Map<String, Object> map = memberService.findId(name); // 인증번호는?
		
		model.addAttribute("id", map.get("id"));
		return "findId"; // 아이디 찾기 완료
	}
	
	@RequestMapping (value="/member/resetPw", method=RequestMethod.POST)
	public String ResetPw () {
		
		return "resetPw"; // 앞에서 받은 아이디에 대한 재설정할 비번 받음
	}
	
	@RequestMapping (value="/member/findPw", method=RequestMethod.POST)
	public String FindPw () {
		return "findPw"; // 앞에서 입력된 재설정비번 완료
	}
	

	
	
}
