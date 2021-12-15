<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<header>
<br>
<div style ="text-align:center;">
<a href="/shop" style="text-align:center;"><img src="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small" alt="logo" style="width: 50px; height=50px;"></a>
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