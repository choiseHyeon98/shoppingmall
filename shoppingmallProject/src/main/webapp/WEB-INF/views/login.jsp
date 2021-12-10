<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>

	   <form name="loginForm" action="login" method="post">
   아이디 : <input type="text" name="id" maxlength="10"> <br>
   비밀번호 : <input type="password" name="pwd" maxlength="10"> <br><br>
   <input type="submit" value="로그인"> <br> 
   <input type="reset" value="지우기"> <br>
   
   <input type="button" value="회원가입하기" onClick="location.href=''">
   <input type="button" value="아이디/비밀번호 찾기" onClick="location.href=''">
   </form>

</body>
</html>