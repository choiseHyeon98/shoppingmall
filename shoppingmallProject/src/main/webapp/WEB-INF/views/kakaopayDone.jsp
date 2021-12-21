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
<title>주문완료</title>
<style>
.outer {
	display: flex;
	justify-content: center;
}

#card-body {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	margin: 0px 50px 0px 50px;
}

#middleTitle {
	text-align: center;
}

.inbody {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	margin: 0px 50px 0px 50px;
	display: flex;
	justify-content: center;
}
</style>
<!-- favicon -->
<%@include file="headerfooter/favicon.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="headerfooter/header.jsp"%>

	<div class="card text-black bg-light my-5 py-4 text-center"
		id="card-body">
		<div>
			<div class="img_center">
				<a href="#" target="_blank"> <img
					src="https://w.namu.la/s/fdeb18748079eec1a3b9e27dc1b5bea0e0a52e22d7517f2e405006d19bdb339d8c876f233afc7b6f42564b33846ca98483a44d9abbabcf5f9c89cd9957193c6f95f4085f292c3ddb48b4acef82c05005"
					alt="이미지" style="width: 100px;">
				</a>
			</div>
		</div>
		<h3 id="middleTitle">결제가 완료되었습니다.</h3>
		<div class="inbody">
			<table style="width: 400px;">
				<tr>
					<td style="width: 50px;" colspan="2">주문정보</td>
					<td style="width: 100px;">최종<br>결제금액
					</td>
				</tr>
				<tbody>
					<tr>
						<td>${proName }</td>
						<td>색상:${orderList.colorOption } <br>
							사이즈:${orderList.sizeOption }
						</td>
						<td>총<em>${orderList.tprice }</em>원
						</td>
						<!-- 상품 최종가격 -->
					</tr>
				</tbody>
			</table>


		</div>
		<hr>
		<br> <input type="button" onclick='location.href="../shop"'
			value="다른 상품 보러 가기">
	</div>

	<%@include file="headerfooter/footer.jsp"%>

</body>
</html>