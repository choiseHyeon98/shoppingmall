<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%@ page import="com.hk.shop.vo.OrderListVO"%>
<!DOCTYPE html>
<html>
<head>

<style>
h2 {
	text-align: center;
}

.card-body {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	margin: 0px 30px 0px 30px;
}

#card-body {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	margin: 0px 30px 0px 30px;
}
</style>

<meta charset="UTF-8">
<title>내 주문 기록</title>
<!-- favicon -->
<%@include file="headerfooter/favicon.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="headerfooter/header.jsp"%>

	<div class="card-body">
		<div class="container px-4 px-lg-5">

			<table align="center" border="1" width="80%">
				<h2>내 주문 기록</h2>
				</div>
				<tr>
					<th>상품이미지</th>
					<th>상품이름/가격/수량/옵션</th>
					<th>배송현황</th>

				</tr>

				<c:set var="delStatus" value="배송완료" />

				<c:choose>
					<c:when test="${empty myOrders}">
						<p align="center">
							<span>주문하신 상품이 없습니다</span>
						</p>
					</c:when>

					<c:when test="${delStatus eq '배송완료'}">

						<c:forEach var="myOrders" items="${myOrders }"
							varStatus="orderNum">
							<tr align="center">
								<td>${myOrders.orderNum },${myOrders.proNum }</td>
								<td>${myOrders.sizeOption },${myOrders.colorOption }</td>
								<td>${myOrders.delStatus }<input type="button" value="리뷰작성"
									onClick="location.href='/shop/s/mypage/addReview?proNum=${myOrders.proNum}'"></td>
							</tr>
						</c:forEach>
						<br>
					</c:when>

					<c:when test="${delStatus ne '배송완료' }">
						<tr>
							<c:forEach var="myOrders" items="${myOrders }"
								varStatus="orderNum">
								<td>${myOrders.orderNum },${myOrders.proNum }</td>
								<td>${myOrders.sizeOption },${myOrders.colorOption }</td>
								<td><input type="text" value="${myOrders.delStatus }"
									name="delStatus" readonly></td>
							</c:forEach>
						</tr>
					</c:when>
				</c:choose>
			</table>
		</div>
	</div>

	<!-- footer -->
	<%@include file="headerfooter/footer.jsp"%>
</body>
</html>