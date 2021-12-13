<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<title>Home</title>
</head>
<body>
	헤더위치//헤더에 로그인 세션 정보 받아서 로그인인지 아닌지에 따라 헤더 정보 바뀜.

	<hr>
	<h1>홈페이지</h1>
	베스트 상품 3개 신상품 카테고리별로 3개씩 오늘배송상품 3개 상품 랜덤 조회
	<hr>
	<c:choose>
		<c:when test="${!empty eventList}">
			<c:forEach var="eventList" items="${eventList }" varStatus="eventNum ">
				<tr align="center">
					<td width="10%">이벤트 번호: ${eventList.eventNum }</td><br>
					<td width="10%">이벤트 이미지: ${eventList.eventImg }</td><br>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
	<!-- 베스트 -->
	<hr>
	<c:choose>
		<c:when test="${!empty bestList}">
			<c:forEach var="bestList" items="${bestList }" varStatus="proNum ">
				<tr align="center">
					<td width="10%">베스트상품 번호: ${bestList.proNum }</td><br>
					<td width="10%">베스트상품 이름: ${bestList.proName }</td><br>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
	<!-- 신상품 -->
	<hr>
	<c:choose>
		<c:when test="${!empty newList}">
			<c:forEach var="newList" items="${newList }" varStatus="proNum ">
				<tr align="center">
					<td width="10%">신상품 번호: ${newList.proNum }</td><br>
					<td width="10%">신상품 이름: ${newList.proName }</td><br>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
	<!-- 오늘배송 -->
	<hr>
	<c:choose>
		<c:when test="${!empty dailyList}">
			<c:forEach var="dailyList" items="${dailyList }" varStatus="proNum ">
				<tr align="center">
					<td width="10%">오늘배송상품 번호: ${dailyList.proNum }</td><br>
					<td width="10%">오늘배송상품 이름: ${dailyList.proName }</td><br>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
	<!-- 랜덤상품 -->
	<hr>
	<c:choose>
		<c:when test="${!empty randomList}">
			<c:forEach var="randomList" items="${randomList }" varStatus="proNum ">
				<tr align="center">
					<td width="10%">랜덤상품 번호: ${randomList.proNum }</td><br>
					<td width="10%">랜덤상품 이름: ${randomList.proName }</td><br>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
	<%@include file ="headerfooter/footer.jsp" %>
</body>
</html>
