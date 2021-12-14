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
<title>검색결과</title>
<!-- script -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- favicon -->
<%@include file ="headerfooter/favicon.jsp" %>
</head>
<!-- body -->
<body>
<!-- header -->
<%@include file ="headerfooter/header.jsp" %>
<div>
	<p>"${serch }"에 대한 검색 결과입니다.
</div>
<div>
	<h3>검색결과가 존재하지 않습니다.</h3>
</div>

<!-- footer -->
<%@include file ="headerfooter/footer.jsp" %>
</body>
</html>