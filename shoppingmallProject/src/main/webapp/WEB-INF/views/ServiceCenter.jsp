<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<title>고객센터</title>
<style>
table {
	border: 1px solid #444444;
	border-collapse: collapse;
	text-align: center;
	justify-content: center;
}

td {
	border: 1px solid #444444;
}

.card-board {
	background-color: light-gray;
	justify-content: center;
	display: flex;
}

.card-body {
	background-color: lightgray;
	margin: 0 50px 0 50px;
	flex: 1 1 auto;
	padding: 1rem 1rem;
	justify-content: center;
	display: flex;
}

.color-black {
	color: black;
}
</style>
<!-- favicon -->
<%@include file="headerfooter/favicon.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="headerfooter/header.jsp"%>
	<div class="card-body">
		<div>
		<h2>고객센터</h2>
		<small>Customer Service</small>
		<p>
			<a class="color-black" href="/shop/board/serviceCenter">> 자주묻는 질문</a>
			<br> <a class="color-black" href="/shop/board/askAdd">> 문의하기</a>
		</p>
		</div>
		<br>
		<div class="card-body">
			<div>
				<div>
					<a href="/shop/board/serviceCenter/order" class="color-black">주문결제</a>|
					<a href="/shop/board/serviceCenter/del" class="color-black">배송안내</a>|
					<a href="/shop/board/serviceCenter/cenOrd" class="color-black">주문취소</a>|
					<a href="/shop/board/serviceCenter/re" class="color-black">교환환불</a>|
					<a href="/shop/board/serviceCenter/pro" class="color-black">상품관련</a>|
					<a href="/shop/board/serviceCenter/mem" class="color-black">회원관련</a>
					<hr>
				</div>
				<br>
				<div class="card-body">
					<table>
						<c:choose>
							<c:when test="${!empty FAQLists}">
								<c:forEach var="FAQLists" items="${FAQLists }"
									varStatus="FAQNum">
									<tr>
										<td class="tdNum" style="width: 30px;">${FAQNum.count }</td>
										<td id="tdTitle" style="width: 200px;"><a
											class="color-black"
											href="/shop/board/questionOne?FAQNum=${FAQLists.FAQNum }">
												${FAQLists.FAQTitle } </a></td>
									<tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@include file="headerfooter/footer.jsp"%>
</body>
</html>