<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<html>
<head>
	<title>ManagerHome</title>
</head>
<body>
헤더위치//헤더에 로그인 세션 정보 받아서 로그인인지 아닌지에 따라 헤더 정보 바뀜.

<hr>
<h1>홈페이지</h1>
이벤트 배너 <br>
베스트상품<br>
<hr>
<c:forEach var="best" items="${bestList }" varStatus="3">
	<tr align="center">
	  <td width="5%">${best.proName }</td>
	</tr>					
</c:forEach>
<hr>
<br>
베스트 상품 3개
신상품 카테고리별로 3개씩
오늘배송상품 3개
상품 랜덤 조회 <br>
	
	
<hr>
푸터위치
</body>
</html>
