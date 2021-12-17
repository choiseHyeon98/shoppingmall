<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>proSoldout</title>
</head>
<body>
<script>
proSoldout();

function proSoldout(){
	var r = "${map.succ}";

	if (r > 0){
		alert("품절처리되었습니다");
		location.replace("http://localhost:8888/shop/manager/managerHome");
	} else {
		document.wirte("에러입니다");
	}
 } 
</script>
</body>
</html>