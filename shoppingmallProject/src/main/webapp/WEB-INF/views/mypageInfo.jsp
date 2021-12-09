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
<title>내 정보</title>
</head>
<body>
내 정보임

	<h3>id : ${id }</h3> <br>
	<h3>pw : ${pw }</h3> <br>
	<h3>name : ${name }</h3> <br>
	<h3>phone : ${phone }</h3> <br>
	<h3>address : ${address }</h3> <br>
	<h3>email : ${email }</h3> <br>
	<h3>joinDate : ${joinDate }</h3> <br>

</body>
</html>