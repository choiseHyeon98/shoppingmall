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
<title>ID/PW 찾기</title>
</head>
<body>

<h1>아이디 찾기</h1>
<form action="findId" method="post">

	NAME : <input type="text" name="name" maxlength="20" required><br>
  <input type="checkbox" name="email" value=${email }/>이메일 인증
  <input type="text" name="email" maxlength="100">
  <input type="button" value="전송"><br>
   
  <input type="checkbox" name="phone" value=${phone }/>전화번호 인증
  <input type="text" name="phone" maxlength="12">
    <input type="button" value="전송"><br>
 
	
	인증번호 입력 : <input type="text" name="pinnum" maxlength="6">
	<input type="button" value="아이디 조회하기" onClick="location.href='findId?name='"><br>
</form>
	


<h1>비밀번호 찾기</h1>
<form action="resetPw" method="post">
NAME : <input type="text" name="name" maxlength="20" required><br>
ID : <input type="text" name="id" maxlength="10" required> <br>
  <input type="checkbox" name="email" value=${email }/>이메일 인증
  <input type="text" name="email" maxlength="100">
  <input type="button" value="전송"><br>
   
  <input type="checkbox" name="phone" value=${phone }/>전화번호 인증
  <input type="text" name="phone" maxlength="12">
    <input type="button" value="전송"><br>
  
  <input type="text" name="" maxlength="100"><br>
	
	인증번호 입력 : <input type="text" name="pinnum" maxlength="6">
	<input type="button" value="비밀번호 재설정" onClick="location.href='resetPw'"><br>

</form>
</body>
</html>