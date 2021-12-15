package com.hk.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hk.shop.vo.MemberVO;

public class LoginInterceptor implements HandlerInterceptor {
	// 이건 나중에
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션 확인
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			response.sendRedirect("/shop/login");
			return false;
		}
		
		// // 세션안에 내용이 login이라고 하는 attribute가 있는지 확인
		MemberVO memberVO = (MemberVO) session.getAttribute("login");
		if (memberVO == null) {
			response.sendRedirect("/shop/login");
			return false;
		}
		// 둘 중에 하나라도 정상이면 로그인 된 상태
		// 아니면 ...redirect("login");
		return false;
		
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
}
