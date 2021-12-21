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
<title>회원 가입</title>
</head>
<body>



<form action="register" method="post">
	ID : <input type="text" name="id" maxlength="10" required><br>
	PW : <input type="text" name="pw" maxlength="20" required><br>
	NAME : <input type="text" name="name" maxlength="20" required><br>
	PHONE : <input type="text" name="phone" maxlength="12"><br>
	ADDRESS : <input type="text" name="address" maxlength="100" required><br>
	EMAIL : <input type="text" name="email" maxlength="100"><br> 
	
	<input type="submit" value="회원가입">
	<input type="reset" value="초기화">
</form>
</body>
</html>