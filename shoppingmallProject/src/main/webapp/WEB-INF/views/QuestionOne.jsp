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
	width: 100%;
	height: 450px;
}

td {
	border: 1px solid #444444;
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
					<h2>고객센터</h2>
					<small>Customer Service</small>
					<p>
						<a class="color-black" href="/shop/board/serviceCenter"> 자주묻는
							질문</a> <br><a class="color-black" href="/shop/s/board/askList">
							내 문의 내역</a> <br> <a class="color-black" href="/shop/s/board/askAdd">
							문의하기</a> <br> 
					</p>
				</div>
				<div class="col-lg-8">
					<div style="text-align:left;">
					<h4>${FAQOne.FAQTitle }</h4>
					<small style="text-align:right;">${FAQOne.id }&nbsp;|&nbsp;${FAQOne.name }&nbsp;|&nbsp;${FAQOne.FAQType }</small>
					<hr>
					</div>
					<div style="text-align: left;">
						<div>
							<table>
								<tr>
									<td>문의내역${FAQOne.FAQContent }</td>
								<tr>
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