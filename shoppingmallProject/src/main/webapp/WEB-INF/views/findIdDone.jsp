<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
#sform {
	width : 350px;
    height : 250px;
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
<title>아이디 찾기 결과</title>
</head>
<body>

<div class="forCenter">
<div id = "sform">
고객님의 ID는 ${memberVO.id } 입니다.
<br>
<br>

<input type="button" value="로그인" onClick="location.href='/shop/login'">
<input type="button" value="비밀번호 찾기" onClick="location.href='/shop/member/findIdPw'">

</div>
</div>

</body>
</html>