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
	border-collapse: collapse;
	text-align: center;
	justify-content: center;
}

td {
	text-align: left;
}

.card-body {
	background-color: #fffef5;
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
		<div class="container px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 align-items-center my-5">
				<div class="col-lg-4" style="text-align: left;">
					<h2><a href="/shop/board/serviceCenter" class="color-black">고객센터</a></h2>
					<small>Customer Service</small>
					<p>
						<a class="color-black" href="/shop/board/serviceCenter">> 자주묻는
							질문</a> <br> <a class="color-black" href="/shop/s/board/askAdd">>
							문의하기</a>
					</p>
				</div>
				<div class="col-lg-8">
					<div>
						<a href="/shop/board/serviceCenter/order" class="color-black">주문결제</a>|
						<a href="/shop/board/serviceCenter/del" class="color-black">배송안내</a>|
						<a href="/shop/board/serviceCenter/cenOrd" class="color-black">주문취소</a>|
						<a href="/shop/board/serviceCenter/re" class="color-black">교환환불</a>|
						<a href="/shop/board/serviceCenter/pro" class="color-black">상품관련</a>|
						<a href="/shop/board/serviceCenter/mem" class="color-black">회원관련</a>
						<hr>
					</div>
					<div style="text-align: center; ">
						<div>
							<table style="margin-left: auto; margin-right: auto;">
								<c:choose>
									<c:when test="${!empty FAQLists}">
										<c:forEach var="FAQLists" items="${FAQLists }"
											varStatus="FAQNum">
											<tr>
												<td class="tdNum" style="width: 30px; text-align: center;">${FAQNum.count }</td>
												<td id="tdTitle" style="width: 120%; text-align:center;"><a
													class="color-black"
													href="/shop/board/questionOne?FAQNum=${FAQLists.FAQNum }">
														${FAQLists.FAQTitle } </a>
												</td>
											</tr>
										</c:forEach>
									</c:when>
								</c:choose>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@include file="headerfooter/footer.jsp"%>
</body>
</html>