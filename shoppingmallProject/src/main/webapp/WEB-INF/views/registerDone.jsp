<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
<body>
	<h1> ${member.name } 님! 
	회원 가입을 축하드립니다!</h1>
	
	<!-- 메인 홈페이지로 가는 URL 버튼 -->
	<input type="button" value="로그인" onClick="location.href='login'">
	<input type="button" value="상품 보러가기" onClick="location.href='/shop/'">
	
</body>
</html>