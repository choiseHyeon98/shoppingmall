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
<title>event!</title>

<!-- favicon -->
<%@include file="headerfooter/favicon.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="headerfooter/header.jsp"%>
	<div style="text-align:center;">
		<img src="/shop/fileDownload?eventImg=${eventList.eventImg}"" alt="event:${eventList.eventTitle }">
		<br>
		<input type="text" style="width:80%; height:100%;" value="${eventList.eventContent }" disabled>
		
	</div>
	<!-- Footer-->
	<%@include file="headerfooter/footer.jsp"%>
</body>
</html>