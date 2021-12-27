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

<style type="text/css">
#sform {
	width : 350px;
    height : 210px;
    border : 1px solid black;
    display : inline-block;
    text-align: center;
	padding: 70px 25px 10px 25px;
}
.forCenter{
	text-align:center;
}
</style>

</head>
<body>
<body>

<div class="forCenter">
<div id="sform">
	<h3> ${name } 님! <br>
	회원 가입을 축하드립니다!</h3>
	
	<!-- 메인 홈페이지로 가는 URL 버튼 -->
	<input type="button" value="로그인" onClick="location.href='/shop/login'">
	<input type="button" value="상품 보러가기" onClick="location.href='/shop/'">
</div>
</div>

</body>
</html>