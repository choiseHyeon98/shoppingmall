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
<title>EventBannerUpdate</title>
</head>
<body>
<script>

update();

function update(){
	var r = "${ret}";
	
	if (r > 0){
		alert("이벤트 배너가 수정되었습니다");
		location.replace("../managerHome");
	} else {
		document.wirte("에러입니다");
	}
 } 
</script>
</body>
</html>