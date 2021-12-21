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



<form name="frmLogin" action="register" method="post">
	<input type="text" name="id" maxlength="10" class="text-field" placeholder="ID" required>
	<input type="button" value="중복체크" onClick='idCheck()'><br>
	<input type="text" name="pw" maxlength="20" class="text-field" placeholder="PW" required><br>
	<input type="text" name="name" maxlength="20" class="text-field" placeholder="NAME" required><br>
	<input type="text" name="phone" maxlength="12" class="text-field" placeholder="PHONE" ><br>
	<input type="text" name="address" maxlength="100" class="text-field" placeholder="ADDRESS" required><br>
	<input type="text" name="email" maxlength="100" class="text-field" placeholder="EMAIL"><br> 
	
	<input type="submit" value="회원가입">
	<input type="reset" value="초기화">
</form>
</body>
<script>
function idCheck(){
	document.frmLogin.action="../../shop/overlapped.do";
	document.frmLogin.submit();
}
</script>
</html>