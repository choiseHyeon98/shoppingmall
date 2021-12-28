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
<!-- favicon -->
<link rel=" shortcut icon" href="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small">
<link rel="icon" href="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small">
<style>
#sform {
	width : 350px;
    height : 300px;
    border : 1px solid black;
    display : inline-block;
    text-align: center;
	padding: 30px 25px 10px 25px;
}

.forCenter {
	text-align:center;
}
</style>

<meta charset="UTF-8">
<title>마이 페이지</title>
</head>
<body>

<div class="forCenter">
<div id = "sform">

<h3>마이페이지</h3>
	<input type="button" value="찜목록" onClick="location.href='/shop/s/mypage/cart'" style="width:250px; height: 30px">
	<br>
	<input type="button" value="주문기록" onClick="location.href='/shop/s/mypage/myorders'" style="width:250px; height: 30px">
	<br>
	<input type="button" value="내 정보 보기" onClick="location.href='/shop/s/mypage/update'" style="width:250px; height: 30px">
	<br>
	<input type="button" value="내 문의 보기" onClick="location.href='/shop/s/board/askList'" style="width:250px; height: 30px">
	<br><br>
	<input type="button" value="상품 보러가기" onClick="location.href='/shop/'" style="width:250px; height: 30px">
</div>
</div>



</body>
</html>