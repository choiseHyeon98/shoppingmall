<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>
</head>
<body>
고객님의 ID는 ${MemberVO.id } 입니다.

<input type="button" value="로그인" onClick="location.href='/shop/login'">
<input type="button" value="비밀번호 찾기" onClick="location.href='/shop/member/findIdPw'">
</body>
</html>