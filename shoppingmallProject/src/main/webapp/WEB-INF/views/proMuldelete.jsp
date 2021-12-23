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
<title>proMuldelete</title>
<script>
proMuldelete();

function proMuldelete(){
	var r = "${map.succ}";

	if (r > 0){
		alert("삭제되었습니다");
		location.replace("/shop/manager/managerHome");
	} else {
		document.wirte("에러입니다");
	}
 } 
</script>

</head>
<body>

</body>
</html>