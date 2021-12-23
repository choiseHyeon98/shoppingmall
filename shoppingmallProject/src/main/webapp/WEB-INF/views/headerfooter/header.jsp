<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<%@ page import = "com.hk.shop.vo.MemberVO" %>

<header>
<br>
<div style ="text-align:center;">
<a href="/shop" style="text-align:center;"><img src="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small" alt="logo" style="width: 50px; height=50px;"></a>


<%
MemberVO memberVO = (MemberVO) session.getAttribute("login");
%>

<%
// 로그인 안되어있는 상태
if (memberVO == null) {
%>
<ul style="float: right;">
<li><input type="button" value="LOGIN" onClick="location.href='/shop/login'"></li>
<li><input type="button" value="REGISTER" onClick="location.href='/shop/member/register'" ></li>
</ul>
<%
// 로그인 된 상태
} else {
%>
<ul style="float: right;">
<li><input type="button" value="마이 페이지" onClick="location.href='/shop/mypage'"></li>
<li><input type="button" value="LOGOUT" onClick="location.href='/shop/logout'" ></li>
</ul>
<%
}
%>

<form action="/shop/product/serch" method="get">
	<select name="serchType">
		<option value="proName" name="proName">상품명</option>
	</select>
<input type="text" name="serch"><input type="submit" value="검색">
</form>
</div>
<hr>
<div id = menu>
<ul>
    <li><a href="/shop/product/listAll" class="m_link">All</a></li>
    <li>| <a href="/shop/product/listCasual" class="m_link">Casual</a></li>
    <li>| <a href="/shop/product/listOffice" class="m_link">Office</a></li>
    <li>| <a href="/shop/product/listFeminine" class="m_link">Feminine</a></li>
    <li>| <a href="/shop/product/listHip" class="m_link">Hip</a></li>
    <li>| <a href="/shop/product/listVintage" class="m_link">Vintage</a></li>
    <li>| <a href="/shop/product/listDaily" class="m_link">Daily</a></li>
</ul>
</div>
<hr>

</header>